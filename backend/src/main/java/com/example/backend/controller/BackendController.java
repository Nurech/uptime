package com.example.backend.controller;


import com.example.backend.model.AllData;
import com.example.backend.model.Booking;
import com.example.backend.service.BookingService;
import com.example.backend.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightService flightService;
    @Autowired
    private BookingService bookingService;


    @CrossOrigin
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/serverinfo")
    public List<AllData> getAllFlights() {
        return flightService.getLatestApiInfo();
    }

    @CrossOrigin
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/bookings")
    public List<Booking> getLatestBookings() {
        return bookingService.getLatestBookings();
    }

    @CrossOrigin
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/savebooking")
    public void getLatestBookings(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
    }

}

