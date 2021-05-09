package com.example.backend.controller;


import com.example.backend.model.ValidUntil;
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
    @RequestMapping(path = "/getValidUntil")
    public String getValidUntil() {
        LOG.info("GET called on validUntil");
        ValidUntil validUntil = flightsRepository.findByRowId(1);
        String databaseResponse = validUntil.getValidUntil();
        String serverTime = timeService.myServerTimeHour() + timeService.myServerTimeYear();
        String getUpdateDatabaseHour = timeService.getUpdateDatabaseHour();
        String getUpdateDatabaseYear = timeService.getUpdateDatabaseYear();
        long difference = timeService.getNextUpdateTime();
        return "DB response= " + databaseResponse + " ServerTime= " + serverTime + " getUpdateHour= " + getUpdateDatabaseHour + " getUpdateYear= " + getUpdateDatabaseYear + " difference= " + difference;
    }

}

