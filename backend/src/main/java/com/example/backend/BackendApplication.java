package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
public class BackendApplication {
    @Scheduled(fixedRate = 60000)
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
