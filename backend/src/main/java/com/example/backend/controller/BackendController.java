package com.example.backend.controller;


import com.example.backend.model.AllData;
import com.example.backend.repository.FlightsRepository;
import com.example.backend.service.FlightService;
import com.example.backend.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightService flightService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private FlightsRepository flightsRepository;

    @CrossOrigin
    @ResponseBody
    @GetMapping(path = "/serverinfo")
    public List<AllData> getAllFlights() {
        return flightService.getLatestApiInfo();
    }

}

