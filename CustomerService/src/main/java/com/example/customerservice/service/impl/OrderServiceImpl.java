package com.example.customerservice.service.impl;

import com.example.customerservice.dto.order.OrderDTO;
import com.example.customerservice.feign.RestaurantClient;
import com.example.customerservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.UserJwtDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RestaurantClient restaurantClient;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public OrderDTO createOrder(OrderDTO order, UserJwtDTO client) {

        order.setUserId(client.getId());
//        restaurantClient.createOrder(order);
        rabbitTemplate.convertAndSend("myQueue", order);

        return order;

    }

    @Override
    @Cacheable(value = "itemCache", key = "#order.id")
    public OrderDTO cacheOrderTest(OrderDTO order) throws InterruptedException {
        Thread.sleep(4000L);

        return order;
    }
}
