package com.example.backend.service;

import com.example.backend.controller.BackendController;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TimeService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @SneakyThrows
    @ResponseBody
    public String getApiUpdateTime() {
        String fullTime = FlightService.downloadJson().substring(59, 78);
        LOG.info("{Get API update time, its:} " + fullTime);
        return fullTime;
    }

    @ResponseBody
    @SneakyThrows
    public Period getNextUpdateTime() {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

        // my time
        Date localTime = new Date();
        DateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("GMT"));
        DateTime myGmtTime = DateTime.parse(s.format(localTime));
        LOG.info("{My server time is:} " + localTime);
        LOG.info("{My server time in GMT is:} " + s.format(localTime));

        // update time is in GMT. no need to format, only parse
        DateTime updateTime = DateTime.parse(getApiUpdateTime(), formatter);

        // how long till next update in mills
        Period period = new Period(myGmtTime, updateTime, PeriodType.millis());
        LOG.info("{Next update in seconds:} " + period.toStandardSeconds());

        return period;
    }
}