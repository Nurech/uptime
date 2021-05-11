package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.model.ServerInfo;
import com.example.backend.repository.FlightsRepository;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;

    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


    @ResponseBody
    public String myServerTimeHour() {
        Date d1 = new Date();
        String formattedDateHour = timeFormat.format(d1);
        return formattedDateHour;
    }

    @ResponseBody
    public String myServerTimeYear() {
        Date d2 = new Date();
        String formattedDateYear = dayFormat.format(d2);
        return formattedDateYear;
    }

    @ResponseBody
    public String getUpdateDatabaseHour() {
        // get valid until from first row
        ServerInfo serverInfo = flightsRepository.findByRowId(1);
        //2021-05-09T03:51:35.0934365Z
        String databaseResponse = serverInfo.getValidUntil().substring(11, 19);
        return databaseResponse;
    }

    @ResponseBody
    public String getUpdateDatabaseYear() {
        ServerInfo serverInfo = flightsRepository.findByRowId(1);
        //2021-05-09T03:51:35.0934365Z
        String databaseResponse = serverInfo.getValidUntil().substring(0, 10);
        return databaseResponse;
    }

    @ResponseBody
    public String getUpdateTime() {
        ServerInfo serverInfo = flightsRepository.findByRowId(1);
        //2021-05-09T03:51:35.0934365Z
        String databaseResponse = serverInfo.getValidUntil().substring(0, 19);
        return databaseResponse;
    }


    @ResponseBody
    @SneakyThrows
    public long getNextUpdateTime() {

//        timezone is Zulu (UTC)
//        2021-05-09T06:21:43.183977Z

        //TODO remember to change this if local or on server
        DateTime startDate = DateTime.now().minusHours(3);

        String dateTime = getUpdateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTime endDate = DateTime.parse(dateTime, formatter);

        Period period = new Period(startDate, endDate, PeriodType.millis());
        long nextUpdate =  period.getMillis();

        LOG.info("my time: " + myServerTimeHour());
        LOG.info("update time: " + getUpdateDatabaseHour());
        LOG.info("startDate: " + startDate);
        LOG.info("endDate: " + endDate);
        LOG.info("mills until update: " + nextUpdate);
        LOG.info("will update in seconds: " + period.toStandardSeconds());
        LOG.info("GET called on getUpdateTimeDifference");
        return nextUpdate;
    }

}
