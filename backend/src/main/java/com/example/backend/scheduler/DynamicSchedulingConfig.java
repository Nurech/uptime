package com.example.backend.scheduler;

import com.example.backend.controller.BackendController;
import com.example.backend.service.FlightService;
import com.example.backend.service.TimeService;
import lombok.SneakyThrows;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class DynamicSchedulingConfig implements SchedulingConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private TimeService timeService;
    @Autowired
    private FlightService flightService;
    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    @SneakyThrows
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(

                // run update db when data has expired
                new Runnable() {
                    @Override
                    public void run() {
                        FlightService.downloadJson();
                        flightService.saveJsonToDatabase();
                    }
                },

                // set trigger to be when time validUntil has arrived
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext context) {
                        long mills = timeService.getNextUpdateTime();
                        Optional<Date> lastCompletionTime =
                                Optional.ofNullable(context.lastCompletionTime());
                        Instant nextExecutionTime =
                                lastCompletionTime.orElseGet(Date::new).toInstant()
                                        .plusMillis(mills);
                        LOG.info("Next update in: " + (mills / 1000) / 60 + " minutes and " + (mills / 1000) % 60 + " seconds. At " + LocalTime.now().plusMillis((int) mills));
                        return Date.from(nextExecutionTime);
                    }
                }
        );
    }
}

