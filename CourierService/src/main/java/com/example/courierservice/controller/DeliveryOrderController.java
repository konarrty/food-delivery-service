package com.example.courierservice.controller;

import com.example.courierservice.model.DeliveryOrder;
import com.example.courierservice.resolver.OAuth2User;
import com.example.courierservice.service.DeliveryOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.DeliveryOrderDTO;
import org.example.commondtos.dto.UserJwtDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class DeliveryOrderController {

    private final DeliveryOrderService deliveryOrdersService;

    @GetMapping
    public ResponseEntity<Flux<DeliveryOrder>> getAllDeliveryOrders() {

        return ResponseEntity.ok(deliveryOrdersService.getAllDeliveryOrders());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<DeliveryOrder> createDeliveryOrders(@RequestBody DeliveryOrder deliveryOrder, @OAuth2User UserJwtDTO user) {

        return deliveryOrdersService.createDeliveryOrders(deliveryOrder, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deleteDeliveryOrders(@PathVariable Long id) {

        return deliveryOrdersService.deleteDeliveryOrderByOrderId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public Mono<?> patchDeliveryOrders(@RequestBody DeliveryOrderDTO deliveryOrderDTO, @PathVariable Long id) {

        return deliveryOrdersService.patchDeliveryOrders(deliveryOrderDTO, id);
    }

}
