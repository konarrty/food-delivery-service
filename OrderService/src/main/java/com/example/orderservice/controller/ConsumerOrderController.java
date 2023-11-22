package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.order.ConsumerOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.commondtos.resolver.OAuth2User;
import org.example.commondtos.dto.OrderDTO;
import org.example.commondtos.dto.UserJwtDTO;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/consumer-orders")
@RequiredArgsConstructor
public class ConsumerOrderController {

    private final ConsumerOrderService orderService;


    @PostMapping
    public Order createOrder(@RequestBody OrderDTO order, @OAuth2User UserJwtDTO userJwtDTO) {
        System.err.println(order);

        return orderService.createOrder(order, userJwtDTO);
    }


    @DeleteMapping("/{id}")
    public Order cancelOrder(@PathVariable Long id) {
        System.err.println(id);

        return orderService.cancelOrder(id);
    }


}
