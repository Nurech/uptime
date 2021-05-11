package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.entity.Flights;
import com.example.backend.model.AllData;
import com.example.backend.repository.FlightsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;

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
            flightData.setRowId(flights.getRowId());
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
            flightData.setRouteFromId(flights.getRouteFromId());
            flightData.setRouteFromName(flights.getRouteFromName());
            flightData.setRouteToId(flights.getRouteToId());
            flightData.setRouteToName(flights.getRouteToName());
            dataList.add(flightData);
        }

        LOG.info("GET all flights data");
        return dataList;
    }

    public List<AllData> getLatest15FlightApiInfo() {

        // order by row id get latest record
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
            flightData.setRowId(flights.getRowId());
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
            flightData.setRouteFromId(flights.getRouteFromId());
            flightData.setRouteFromName(flights.getRouteFromName());
            flightData.setRouteToId(flights.getRouteToId());
            flightData.setRouteToName(flights.getRouteToName());
            dataList.add(flightData);
        }

        LOG.info("GET all flights data");
        return dataList;
    }

}
