package com.example.backend.controller;


import com.example.backend.service.CosmosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BackendController {

    @Autowired
    private CosmosService cosmosService;
//
//    @ResponseBody
//    @RequestMapping(path = "api/info/", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public List<Flights> addNewRole() { return cosmosService.allInfo(); }
//
//    @ResponseBody
//    @RequestMapping(path = "api/post/", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public List<Flights> addNewRole() { return cosmosService.allInfo(); }

}
