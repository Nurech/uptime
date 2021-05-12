package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.entity.Flights;
import com.example.backend.model.AllData;
import com.example.backend.model.Flight;
import com.example.backend.repository.BookingsRepository;
import com.example.backend.repository.FlightsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;
    @Autowired
    private BookingsRepository bookingsRepository;

    public List<AllData> getLatestApiInfo() {

        // get latest record
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
        LOG.info("GET all flights data");
        return dataList;
    }

    public List<AllData> getLatest15FlightApiInfo() {

        // get last 15 API ID's
        Pageable pageable =  PageRequest.of(0, 15);

        // order by row id get latest record
        List<Flights> latestApiIdList = (flightsRepository.findAllByOrderByIdDesc(pageable));
        LOG.info("Latest 15 API list size is: " + latestApiIdList.size());

        // where to save all latest results
        List<AllData> dataList = new ArrayList<>();

        for (int i = 0; i < latestApiIdList.size();i++) {

            // swap data from entity to dto
            List<Flights> flightEntity = flightsRepository.findAllById(latestApiIdList.get(i).getId());
            LOG.info("Found latest records for:" + latestApiIdList.get(i) + " List size is: " + flightEntity.size());

            for (Flights flights : flightEntity) {

                // create obj in loop
                AllData flightData = new AllData();
                flightData.setId(flights.getId());
                flightData.setValidUntil(flights.getValidUntil());
                dataList.add(flightData);
            }
        }

        LOG.info("GET all flights data");
        return dataList;
    }

    @SneakyThrows
    public void saveJsonToDatabase() {

        // take original JSON
        File jsonData = new File("backend/src/main/resources/downloads/original.json");
        ObjectMapper mapper = new ObjectMapper();
        Flight rawJsonData = mapper.readValue(jsonData, Flight.class);

        // reformat json
        StringBuilder jsonBuilder = new StringBuilder();
        int atObject = 0;
        int parent = 0;
        int child = 0;

        int parentsTotal = (rawJsonData.getLegs().size() - 1);
        int childsTotal = (rawJsonData.getLegs().get(parent).getProviders().size()) - 1;
        int totalObjects = parentsTotal * childsTotal;

        LOG.info(("{Reading downloaded JSON: parentsTotal: " + parentsTotal + " childsTotal: " + childsTotal + "}"));

        while ((parent < parentsTotal) && (child < childsTotal) || (atObject < totalObjects)) {
            Flight flight = new Flight();
            flight.setId(rawJsonData.getId());
            flight.setValidUntil(rawJsonData.getValidUntil());
            flightsRepository.save(flight)
            child++;
            atObject++;

            // go to next parent, reset child to zero
            if (child == childsTotal) {
                child = 0;
                if (parent < parentsTotal) {

                    // how many children next parent has?
                    parent++;
                    childsTotal = (rawJsonData.getLegs().get(parent).getProviders().size());
                }
            }
        }
        LOG.info("{Saved downloaded JSON to db}");
    }

}
