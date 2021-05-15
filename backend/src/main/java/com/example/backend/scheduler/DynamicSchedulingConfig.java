package com.example.backend.scheduler;

import com.example.backend.controller.BackendController;
import com.example.backend.service.FlightService;
import com.example.backend.service.TimeService;
import lombok.SneakyThrows;
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

                // run update db when next execution has arrived
                new Runnable() {
                    @Override
                    public void run() {
                        LOG.info("{Fetching new API info, updating database}");
                        FlightService.downloadJson();
                        flightService.saveJsonToDatabase();
                    }
                },

                // set trigger to be when time validUntil has expired
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext context) {

                        // period how long between my server time to new API time
                        long seconds = timeService.getNextUpdateTime().toStandardSeconds().getSeconds();

                        Optional<Date> lastCompletionTime =
                                Optional.ofNullable(context.lastCompletionTime());
                        Instant nextExecutionTime =
                                lastCompletionTime.orElseGet(Date::new).toInstant()
                                        .plusSeconds(seconds);

                        LOG.info("{Next update execution is at:} " + nextExecutionTime);

                        return Date.from(nextExecutionTime);
                    }
                }
        );
    }
}

