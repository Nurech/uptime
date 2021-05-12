package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.scheduler.ConvertJsonDataToSql;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

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

    @SneakyThrows
    @ResponseBody
    public String latestValidUntil() {
        try {
            // get latest valid until hour from latest API JSON
            String jsonFileToString = Files.readString(Path.of("backend/src/main/resources/downloads/original.json"));
            // target T03:51:35
            String time = jsonFileToString.substring(70, 78);
            return time;
        } catch (Exception e) {
            LOG.info("Latest info check error. No JSON file. Going to download and update.");
        } finally {
            new ConvertJsonDataToSql();
        }
        //TODO make this better
        return "Error. No JSON file. Can't download.";
    }

    @SneakyThrows
    @ResponseBody
    public String getUpdateDatabaseYear() {
        String jsonFileToString = Files.readString(Path.of("backend/src/main/resources/downloads/original.json"));
        // target is latest: 03:51:35.0934365Z
        String year = jsonFileToString.substring(59, 68);
        return year;
    }

    @SneakyThrows
    @ResponseBody
    public String getApiUpdateTime() {
        try {
            // get latest valid until hour from latest API JSON
            String jsonFileToString = Files.readString(Path.of("backend/src/main/resources/downloads/original.json"));
            // target T03:51:35
            String fullTime = jsonFileToString.substring(59, 78);
            return fullTime;
        } catch (Exception e) {
            LOG.info("Latest info check error. No JSON file. Going to download and update.");
        }
        // download JSON
        new ConvertJsonDataToSql().getJsonGetSql();
        //TODO make this better
        String jsonFileToString = Files.readString(Path.of("backend/src/main/resources/downloads/original.json"));
        String fullTime = jsonFileToString.substring(59, 78);
        return fullTime;
    }


    @ResponseBody
    @SneakyThrows
    public long getNextUpdateTime() {

        // Z stands for timezone is Zulu (UTC)
        // 2021-05-09T06:21:43.183977Z
        // my time is 3 hours behind from API server
        DateTime startDate = DateTime.now().minusHours(3);

        String dateTime = getApiUpdateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTime endDate = DateTime.parse(dateTime, formatter);

        // how long till next update in mills
        Period period = new Period(startDate, endDate, PeriodType.millis());
        long nextUpdate = period.getMillis();

        LOG.info("my time: " + myServerTimeHour());
        LOG.info("update time: " + latestValidUntil());
        LOG.info("startDate: " + startDate);
        LOG.info("endDate: " + endDate);
        LOG.info("mills until update: " + nextUpdate);
        LOG.info("will update in seconds: " + period.toStandardSeconds());
        LOG.info("GET called on getUpdateTimeDifference");
        return nextUpdate;
    }

}
