package com.example.backend.scheduler;

import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;


public class RunningScripts {
    @Scheduled(fixedRate = 60000)
    public static void main(String[] args) {
        updateDatabase();
    }


    @SneakyThrows
    public static void updateDatabase() {

        // DOWNLOAD JSON
        GetJsonGetSql getJsonGetSql = new GetJsonGetSql();
        getJsonGetSql.getJsonGetSql();

        // reformat SQL script before running, add DO UPDATE
        EditSqlCommands editSqlCommands = new EditSqlCommands();
        editSqlCommands.editSqlCommands();
        Thread.sleep(100);

        //Registering the Driver
        DriverManager.registerDriver(new org.postgresql.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:postgresql://database-2.crctjy69pvad.us-east-2.rds.amazonaws.com:5432/";
        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "password");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("backend/src/main/resources/downloads/flights.sql"));
        //Running the script
        sr.runScript(reader);
    }
}