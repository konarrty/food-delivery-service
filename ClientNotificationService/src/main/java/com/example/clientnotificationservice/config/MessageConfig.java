package com.example.clientnotificationservice.config;

import com.example.clientnotificationservice.dto.SubscriptionData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MessageConfig {
    @Bean
    public Map<String, SubscriptionData> subscriptionDataMap() {

        return new ConcurrentHashMap<>();
    }
}
