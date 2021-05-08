package com.example.backend.scheduler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EditSqlCommands {

    public void editSqlCommands() {

        // REPLACE TRAILING PART OF SQL SCRIPT TO DO UPDATES
        File textFile = new File("backend/src/main/resources/downloads/flights.sql");
        String end = " \nON CONFLICT (row_id)\n" +
                "DO UPDATE SET id = excluded.id,\n" +
                "              \"validUntil\" = excluded.\"validUntil\",\n" +
                "              legs_id= excluded.legs_id,\n" +
                "              \"legs_routeInfo_id\"=excluded.\"legs_routeInfo_id\",\n" +
                "              \"legs_routeInfo_from_name\"=excluded.\"legs_routeInfo_from_name\",\n" +
                "              \"legs_routeInfo_to_id\" = excluded.\"legs_routeInfo_to_id\",\n" +
                "              \"legs_routeInfo_to_name\"=excluded.\"legs_routeInfo_to_name\",\n" +
                "              \"legs_routeInfo_distance\"=excluded.\"legs_routeInfo_distance\",\n" +
                "              \"legs_providers_id\"=excluded.\"legs_providers_id\",\n" +
                "              \"legs_providers_company_id\"=excluded.\"legs_providers_company_id\",\n" +
                "              \"legs_providers_company_name\"=excluded.\"legs_providers_company_name\",\n" +
                "              \"legs_providers_price\"=excluded.\"legs_providers_price\",\n" +
                "              \"legs_providers_flightStart\"=excluded.\"legs_providers_flightStart\",\n" +
                "              \"legs_providers_flightEnd\"=excluded.\"legs_providers_flightEnd\";";

        try {

            // remove "replaceME" replace with row number
            String data = FileUtils.readFileToString(textFile);
            data = data.split(";")[1];
            int counter = 0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '(') {
                    data = data.replaceFirst("replaceME",String.format("%d", counter));
                    counter++;
                }
            }

            FileUtils.writeStringToFile(textFile, data + end);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}