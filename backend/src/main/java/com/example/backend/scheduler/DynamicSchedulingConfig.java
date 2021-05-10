package com.example.backend.scheduler;

import com.example.backend.controller.BackendController;
import com.example.backend.service.TimeService;
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

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(

                // run when time has arrived has arrived
                new Runnable() {
                    @Override
                    public void run() {
                        RunningScripts.updateDatabase();
                    }
                },

                // set trigger to be last run time + mills (mills are from now till future time)
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext context) {
                        long mills = timeService.getNextUpdateTime();
                        Optional<Date> lastCompletionTime =
                                Optional.ofNullable(context.lastCompletionTime());
                        Instant nextExecutionTime =
                                lastCompletionTime.orElseGet(Date::new).toInstant()
                                        .plusMillis(mills);
                        LOG.info("next update in mills: " + mills + " OR " + (mills / 1000) / 60 + " minutes and " + (mills / 1000) % 60 + " seconds");
                        return Date.from(nextExecutionTime);
                    }
                }
        );
    }
}

