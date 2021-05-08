package com.example.backend.controller;


import com.example.backend.entity.Flights;
import com.example.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class BackendController {

    @Autowired
    private FlightService flightService;

    @ResponseBody
    @RequestMapping(path = "api/getAll", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Flights> getAll() {
        return flightService.getAll();
    }

    @ResponseBody
    @RequestMapping(path = "api/getTime", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Flights getAll( Flights request) {
//        return flightService.getAll().get();
        return request;
    }

}

