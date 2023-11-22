package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.order.RestaurantOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.ActiveOrder;
import org.example.commondtos.enums.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant-orders")
@RequiredArgsConstructor
public class RestaurantOrderController {

    private final RestaurantOrderService orderService;

    @GetMapping("/{restaurantId}")
    public List<ActiveOrder> getAllOrderByStatus(@RequestParam(required = false) OrderStatus status, @PathVariable Long restaurantId) {

        if (status == null)
            return orderService.getActiveOrders(restaurantId);
        else
            return orderService.getAllOrderByStatus(restaurantId, status);
    }

    @PostMapping("/{id}")
    public Order updateOrderStatus(@RequestParam OrderStatus orderStatus, @PathVariable Long id) {

        return orderService.updateOrderStatus(id, orderStatus);
    }


}
