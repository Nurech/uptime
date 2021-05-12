package com.example.backend.scheduler;

import com.example.backend.controller.BackendController;
import com.example.backend.service.TimeService;
import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@EnableScheduling
public class UpdateDatabase {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    @Autowired
    private TimeService timeService;

    @SneakyThrows
    public static void updateDatabase() {

        // download JSON, reformat, convert to SQL commands
        JsonToSql jsonToSql = new JsonToSql();
        jsonToSql.getJsonGetSql();

        // reformat SQL script before running, add DO UPDATE
        SqlScript sqlScript = new SqlScript();
        sqlScript.editSqlCommands();
        Thread.sleep(100);

        //Registering the Driver
        DriverManager.registerDriver(new org.postgresql.Driver());

        //Getting the connection
        String mysqlUrl = "jdbc:postgresql://database-2.crctjy69pvad.us-east-2.rds.amazonaws.com:5432/";
        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "password");
        System.out.println("Connection established... Doing SQL query INSERT INTO");

        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);

        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("backend/src/main/resources/downloads/flights.sql"));

        //Running the script
        sr.runScript(reader);

    }
}