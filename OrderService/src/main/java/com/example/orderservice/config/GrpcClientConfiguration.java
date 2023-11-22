package com.example.orderservice.config;

import com.example.CourierServiceGrpc;
import com.example.GreetingServiceGrpc;
import com.example.RestaurantServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class GrpcClientConfiguration {

    @Bean
    GreetingServiceGrpc.GreetingServiceBlockingStub loansServiceStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        return GreetingServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    RestaurantServiceGrpc.RestaurantServiceBlockingStub restaurantWorkingTimeServiceBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        return RestaurantServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    CourierServiceGrpc.CourierServiceBlockingStub courierServiceBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();

        return CourierServiceGrpc.newBlockingStub(channel);
    }

}