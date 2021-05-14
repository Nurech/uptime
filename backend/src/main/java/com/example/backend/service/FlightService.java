package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.entity.Flights;
import com.example.backend.model.AllData;
import com.example.backend.model.Flight;
import com.example.backend.repository.FlightsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.writeString;

@Service
@EnableScheduling
public class FlightService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;

    public List<AllData> getLatestApiInfo() {
        LOG.info("GET all flights data");

        String latestApiId = (flightsRepository.findTopByOrderByRowIdDesc().getId());
        LOG.info("Latest API ID is: " + latestApiId);

        // swap data from entity to dto
        List<Flights> flightEntity = flightsRepository.findAllById(latestApiId);
        LOG.info("Found latest records. List size is: " + flightEntity.size());

        // where to save all latest results
        List<AllData> dataList = new ArrayList<>();

        for (Flights flights : flightEntity) {

            // create obj in loop
            AllData flightData = new AllData();

            flightData.setId(flights.getId());
            flightData.setValidUntil(flights.getValidUntil());
            flightData.setLegsId(flights.getLegsId());
            flightData.setProviderId(flights.getProviderId());
            flightData.setProviderFlightEnd(flights.getProviderFlightEnd());
            flightData.setProviderFlightStart(flights.getProviderFlightStart());
            flightData.setProviderPrice(flights.getProviderPrice());
            flightData.setRouteId(flights.getRouteId());
            flightData.setRouteFromId(flights.getRouteFromId());
            flightData.setRouteDistance(flights.getRouteDistance());
            flightData.setRouteFromName(flights.getRouteFromName());
            flightData.setRouteToId(flights.getRouteToId());
            flightData.setRouteToName(flights.getRouteToName());
            flightData.setProviderCompanyId(flights.getProviderCompanyId());
            flightData.setProviderCompanyName(flights.getProviderCompanyName());
            dataList.add(flightData);
        }
        return dataList;
    }

    @SneakyThrows
    // deadman solution to run this only once at startup to get fresh data when testing on local
    @Scheduled(initialDelay = 1000 * 30, fixedDelay = Long.MAX_VALUE)
    public void saveJsonToDatabase() {

        // get data
        String jsonData = FlightService.downloadJson();
        ObjectMapper mapper = new ObjectMapper();
        Flight rawJsonData = mapper.readValue(jsonData, Flight.class);

        int atObject = 0;
        int parent = 0;
        int child = 0;

        int parentsTotal = (rawJsonData.getLegs().size() - 1);
        int childsTotal = (rawJsonData.getLegs().get(parent).getProviders().size()) - 1;
        int totalObjects = parentsTotal * childsTotal;

        LOG.info(("{Updating database} parentsTotal: " + parentsTotal + " childsTotal: " + childsTotal + "}"));

        while ((parent < parentsTotal) && (child < childsTotal) || (atObject < totalObjects)) {
            Flights flight = new Flights();

            flight.setId(rawJsonData.getId());
            flight.setValidUntil(rawJsonData.getValidUntil());
            flight.setLegsId(rawJsonData.getLegs().get(parent).getId());
            flight.setRouteId(rawJsonData.getLegs().get(parent).getRouteInfo().getId());
            flight.setRouteFromId(rawJsonData.getLegs().get(parent).getRouteInfo().getFrom().getId());
            flight.setRouteFromName(rawJsonData.getLegs().get(parent).getRouteInfo().getFrom().getName());
            flight.setRouteToId(rawJsonData.getLegs().get(parent).getRouteInfo().getTo().getId());
            flight.setRouteToName(rawJsonData.getLegs().get(parent).getRouteInfo().getTo().getName());
            flight.setRouteDistance(rawJsonData.getLegs().get(parent).getRouteInfo().getDistance());
            flight.setProviderId(rawJsonData.getLegs().get(parent).getProviders().get(child).getId());
            flight.setProviderPrice(rawJsonData.getLegs().get(parent).getProviders().get(child).getPrice());
            flight.setProviderFlightStart(rawJsonData.getLegs().get(parent).getProviders().get(child).getFlightStart());
            flight.setProviderFlightEnd(rawJsonData.getLegs().get(parent).getProviders().get(child).getFlightEnd());
            flight.setProviderCompanyId(rawJsonData.getLegs().get(parent).getProviders().get(child).getCompany().getId());
            flight.setProviderCompanyName(rawJsonData.getLegs().get(parent).getProviders().get(child).getCompany().getName());
            flightsRepository.save(flight);

            child++;
            atObject++;

            if (child == childsTotal) {
                child = 0;
                if (parent < parentsTotal) {
                    // how many children next parent has?
                    parent++;
                    childsTotal = (rawJsonData.getLegs().get(parent).getProviders().size());
                }
            }
        }
        LOG.info("{Saved JSON to db}");
    }

    @SneakyThrows
    public static String downloadJson() {

        String jsonUrl = "https://cosmos-odyssey.azurewebsites.net/api/v1.0/TravelPrices";

        // download original JSON
        String json = "";
        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string

            // save string as JSON
            Path path = Paths.get("backend/src/main/resources/downloads/original.json");
            String contents = json;
            try {
                writeString(path, contents, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                // TODO Handle exception
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        LOG.info("{\"Status\":\"JSON Downloaded\"} " + json.substring(1, 44) + "...");
        return json;
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
        return text;
    }
}
