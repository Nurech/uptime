package com.example.backend.scheduler;

import com.example.backend.controller.BackendController;
import com.example.backend.model.Flight;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToObject {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @SneakyThrows
    public static void reformat() throws JsonParseException, JsonMappingException, IOException {

        // take original JSON
        File jsonData = new File("backend/src/main/resources/downloads/original.json");
        ObjectMapper mapper = new ObjectMapper();
        Flight flight = mapper.readValue(jsonData, Flight.class);

        // reformat json
        StringBuilder jsonBuilder = new StringBuilder();
        int atObject = 0;
        int parent = 0;
        int child = 0;
        int parentsTotal = (flight.getLegs().size() - 1);
        int childsTotal = (flight.getLegs().get(parent).getProviders().size()) - 1;
        int totalObjects = parentsTotal * childsTotal;
        System.out.println(("{New JSON created: parentsTotal: " + parentsTotal + " childsTotal: " + childsTotal+"}"));

        while ((parent < parentsTotal) && (child < childsTotal) || (atObject < totalObjects)) {
            jsonBuilder.append("{\"row_id\":\"").append(atObject).append("\",");
            jsonBuilder.append("\"id\":\"").append(flight.getId()).append("\",");
            jsonBuilder.append("\"valid_until\":\"").append(flight.getValidUntil()).append("\",");
            jsonBuilder.append("\"leg_id\":\"").append(flight.getLegs().get(parent).getId()).append("\",");
            jsonBuilder.append("\"route_id\":\"").append(flight.getLegs().get(parent).getRouteInfo().getId()).append("\",");
            jsonBuilder.append("\"route_from_id\":\"").append(flight.getLegs().get(parent).getRouteInfo().getFrom().getId()).append("\",");
            jsonBuilder.append("\"route_from_name\":\"").append(flight.getLegs().get(parent).getRouteInfo().getFrom().getName()).append("\",");
            jsonBuilder.append("\"route_to_id\":\"").append(flight.getLegs().get(parent).getRouteInfo().getTo().getId()).append("\",");
            jsonBuilder.append("\"route_to_name\":\"").append(flight.getLegs().get(parent).getRouteInfo().getTo().getName()).append("\",");
            jsonBuilder.append("\"route_distance\":\"").append(flight.getLegs().get(parent).getRouteInfo().getDistance()).append("\",");
            jsonBuilder.append("\"provider_id\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getId()).append("\",");
            jsonBuilder.append("\"provider_price\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getPrice()).append("\",");
            jsonBuilder.append("\"provider_flight_start\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getFlightStart()).append("\",");
            jsonBuilder.append("\"provider_flight_end\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getFlightEnd()).append("\",");
            jsonBuilder.append("\"provider_company_id\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getCompany().getId()).append("\",");
            jsonBuilder.append("\"provider_company_name\":\"").append(flight.getLegs().get(parent).getProviders().get(child).getCompany().getName()).append("\"},\n ");
            child++;
            atObject++;
           // System.out.println("atObject: " + atObject + "/" + totalObjects + " parent " + parent + " child " + child);

            if (child == childsTotal) {
                child = 0;
                if (parent < parentsTotal) {
                    // how many children next parent has?
                    parent++;
                    childsTotal = (flight.getLegs().get(parent).getProviders().size());
                }
            }
        }

        // add wrapper for flights to make valid JSON
        jsonBuilder.deleteCharAt(jsonBuilder.length()-3).insert(0,"{ \n \"flights\": [ \n").append("]}");

        // save new JSON to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("backend/src/main/resources/downloads/newJson.json"));
        writer.write(jsonBuilder.toString());
        writer.close();

        // display results
//        String result = jsonBuilder.toString();
//        System.out.println(result);
    }
}
