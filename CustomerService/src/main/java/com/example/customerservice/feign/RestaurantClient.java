package com.example.customerservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:8080/restaurant-service", name = "restaurant")
public interface RestaurantClient {

//    @PostMapping(value = "/orders/")
//    Order createOrder(Order order);

}
