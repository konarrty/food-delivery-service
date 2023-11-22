package com.example.orderservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.commondtos.dto.OrderDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {

        return args -> {


        };
    }

}
