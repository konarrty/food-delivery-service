package com.example.customerservice.controller;

import com.example.customerservice.dto.order.OrderDTO;
import com.example.customerservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.UserJwtDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/")
    public OrderDTO createOrder(@RequestBody OrderDTO order, UserJwtDTO user) {

        return orderService.createOrder(order, user);

    }

//    @GetMapping("/cache")
//    public Order cacheOrderTest(@RequestParam("description") String description) throws InterruptedException {
//
//        return orderService.cacheOrderTest(new Order());
//
//    }

}
