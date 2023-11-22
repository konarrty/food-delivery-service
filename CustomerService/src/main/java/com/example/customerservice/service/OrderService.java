package com.example.customerservice.service;

import com.example.customerservice.dto.order.OrderDTO;
import org.example.commondtos.dto.UserJwtDTO;

public interface OrderService {
    OrderDTO createOrder(OrderDTO order, UserJwtDTO client);

    OrderDTO cacheOrderTest(OrderDTO order) throws InterruptedException;
}
