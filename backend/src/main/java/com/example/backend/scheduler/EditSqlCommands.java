package com.example.backend.scheduler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EditSqlCommands {

    public void editSqlCommands() {

        // edit sql query before pushing latest API info into db
        File textFile = new File("backend/src/main/resources/downloads/flights.sql");
        try {

            // do adjustments to incorrect parsing
            String data = FileUtils.readFileToString(textFile);
            data = data.stripTrailing().replaceAll("'DEFAULT'","DEFAULT").replaceAll("flights_","");
            FileUtils.writeStringToFile(textFile, data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}