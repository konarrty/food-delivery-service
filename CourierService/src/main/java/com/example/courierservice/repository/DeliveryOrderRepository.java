package com.example.courierservice.repository;

import com.example.courierservice.model.DeliveryOrder;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DeliveryOrderRepository extends R2dbcRepository<DeliveryOrder, Long> {
    Mono<Boolean> existsByOrderId(Long orderId);

    Mono<Void> deleteByOrderId(Long orderId);

}
