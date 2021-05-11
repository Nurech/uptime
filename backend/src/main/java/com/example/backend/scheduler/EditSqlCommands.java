package com.example.backend.scheduler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EditSqlCommands {

    public void editSqlCommands() {

        // insert fresh data int table flights, keep it updated with most recent info
        // REPLACE TRAILING PART OF SQL SCRIPT TO DO UPDATES
        File textFile = new File("backend/src/main/resources/downloads/flights.sql");
//        String end = " \nON CONFLICT (row_id)\n" +
//                "DO UPDATE SET row_id = excluded.row_id,\n" +
//                "              \"id\" = excluded.\"id\",\n" +
//                "              \"valid_until\" = excluded.\"valid_until\",\n" +
//                "              \"leg_id\" = excluded.\"leg_id\",\n" +
//                "              \"route_id\"=excluded.\"route_id\",\n" +
//                "              \"route_from_id\"=excluded.\"route_from_id\",\n" +
//                "              \"route_from_name\" = excluded.\"route_from_name\",\n" +
//                "              \"route_to_id\"=excluded.\"route_to_id\",\n" +
//                "              \"route_to_name\"=excluded.\"route_to_name\",\n" +
//                "              \"route_distance\"=excluded.\"route_distance\",\n" +
//                "              \"provider_id\"=excluded.\"provider_id\",\n" +
//                "              \"provider_price\"=excluded.\"provider_price\",\n" +
//                "              \"provider_flight_start\"=excluded.\"provider_flight_start\",\n" +
//                "              \"provider_flight_end\"=excluded.\"provider_flight_end\",\n" +
//                "              \"provider_company_id\"=excluded.\"provider_company_id\",\n" +
//                "              \"provider_company_name\"=excluded.\"provider_company_name\";";

        try {

            // read SQL file, add update commands, rewrite flights table data after it's expired
            String data = FileUtils.readFileToString(textFile);
            // remove last ; to add ending part
//            data = data.stripTrailing().replaceAll(";$","").replaceAll("flights_","");
            data = data.stripTrailing().replaceAll("'DEFAULT'","DEFAULT").replaceAll("flights_","");
            FileUtils.writeStringToFile(textFile, data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}