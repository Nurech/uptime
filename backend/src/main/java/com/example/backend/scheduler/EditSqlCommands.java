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
                "              \"valid_until\" = excluded.\"valid_until\",\n" +
                "              legs_id= excluded.legs_id,\n" +
                "              \"legs_route_info_id\"=excluded.\"legs_route_info_id\",\n" +
                "              \"legs_route_info_from_name\"=excluded.\"legs_route_info_from_name\",\n" +
                "              \"legs_route_info_to_id\" = excluded.\"legs_route_info_to_id\",\n" +
                "              \"legs_route_info_to_name\"=excluded.\"legs_route_info_to_name\",\n" +
                "              \"legs_route_info_distance\"=excluded.\"legs_route_info_distance\",\n" +
                "              \"legs_providers_id\"=excluded.\"legs_providers_id\",\n" +
                "              \"legs_providers_company_id\"=excluded.\"legs_providers_company_id\",\n" +
                "              \"legs_providers_company_name\"=excluded.\"legs_providers_company_name\",\n" +
                "              \"legs_providers_price\"=excluded.\"legs_providers_price\",\n" +
                "              \"legs_providers_flight_start\"=excluded.\"legs_providers_flight_start\",\n" +
                "              \"legs_providers_flight_end\"=excluded.\"legs_providers_flight_end\";";

        try {

            // generated SQL has "rowId":"replaceME"
            // remove "replaceME" replace with row number
            String data = FileUtils.readFileToString(textFile);
            int counter = 0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '(') {
                    data = data.replaceFirst("replaceME",String.format("%d", counter));
                    counter++;
                }
            }

            // fix stupid column names, use snake case
            data = data.replaceAll("flightStart","flight_start");
            data = data.replaceAll("flightEnd","flight_end");
            data = data.replaceAll("routeInfo","route_info");
            data = data.replaceAll("validUntil","valid_until");

            // remove last ; to add ending part
            data = data.stripTrailing().replaceAll(";$","");
            FileUtils.writeStringToFile(textFile, data + end);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}