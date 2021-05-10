package com.example.backend.controller;


import com.example.backend.model.ServerInfo;
import com.example.backend.repository.FlightsRepository;
import com.example.backend.service.FlightService;
import com.example.backend.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(path = "/serverinfo")
    public ServerInfo getValidUntil() {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setId(flightsRepository.findByRowId(1).getId());
        serverInfo.setValidUntil(flightsRepository.findByRowId(1).getValidUntil());
        serverInfo.setServerTime(timeService.myServerTimeHour());
        serverInfo.setUpdateTime(timeService.getUpdateDatabaseHour());
        serverInfo.setNextUpdate(timeService.getNextUpdateTime());
        LOG.info("GET called on serverInfo");
        return serverInfo;
    }

}

