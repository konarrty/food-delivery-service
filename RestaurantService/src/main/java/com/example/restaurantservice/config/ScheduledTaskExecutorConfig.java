package com.example.restaurantservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingTaskExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class ScheduledTaskExecutorConfig {

    @Bean
    public ScheduledExecutorService schedulingTaskExecutor(){

        return new ScheduledThreadPoolExecutor(12);
    }
}
