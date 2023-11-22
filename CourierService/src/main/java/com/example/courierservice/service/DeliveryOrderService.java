package com.example.courierservice.service;

import com.example.courierservice.model.DeliveryOrder;
import org.example.commondtos.dto.DeliveryOrderDTO;
import org.example.commondtos.dto.UserJwtDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeliveryOrderService {
    Flux<DeliveryOrder> getAllDeliveryOrders();

    Mono<DeliveryOrder> createDeliveryOrders(DeliveryOrder deliveryOrder, UserJwtDTO user);

    Mono<?> patchDeliveryOrders(DeliveryOrderDTO newDeliveryOrders, Long id);

    Mono<Void> deleteDeliveryOrderByOrderId(Long id);

    Mono<Boolean> existByOrderId(Long id);

    Mono<?> getDeliveryOrdersById(Long id);
}
