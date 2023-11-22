package com.example.restaurantservice;

import com.example.restaurantservice.repository.DishRepository;
import com.example.restaurantservice.service.RestaurantService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantServiceApplication {

    public static void main(final String... args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }


}
