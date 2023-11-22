package com.example.courierservice.repository;

import com.example.courierservice.model.Courier;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface CourierRepository extends R2dbcRepository<Courier, Long> {

    Mono<Courier> findByUserId(UUID userId);

}
