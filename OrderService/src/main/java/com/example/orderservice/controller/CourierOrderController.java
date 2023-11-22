package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.order.CourierOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.ActiveOrder;
import org.example.commondtos.enums.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier-orders")
@RequiredArgsConstructor
public class CourierOrderController {

    private final CourierOrderService orderService;

    @GetMapping("/")
    public List<ActiveOrder> getAllOrderByStatus(@RequestParam(required = false) OrderStatus status) {

        if (status == null)
            return orderService.getActiveOrders();
        else
            return orderService.getAllOrderByStatus(status);
    }


    @PostMapping("/{id}")
    public Order updateOrderStatus(@RequestParam OrderStatus status, @PathVariable Long id) {

        return orderService.updateOrderStatus(id, status);
    }

}
