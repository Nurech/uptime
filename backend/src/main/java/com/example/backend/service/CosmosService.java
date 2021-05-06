package com.example.backend.service;


import com.example.backend.controller.BackendController;
import com.example.backend.model.Flights;
import com.example.backend.repository.FlightsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CosmosService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    FlightsRepository flightsRepository;

    public List<Flights> allInfo(){
        return flightsRepository.findAll();
    }
}
