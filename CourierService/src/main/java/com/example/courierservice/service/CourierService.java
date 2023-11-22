package com.example.courierservice.service;

import com.example.courierservice.model.Courier;
import org.example.commondtos.dto.CourierDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourierService {
    Flux<Courier> getAllCouriers(int page);

    Mono<Courier> createCourier(Courier courier);

    Mono<Courier> patchCouriers(CourierDTO newCourier, Long id);

    Mono<Void> deleteCourier(Long id);

    Mono<Courier> getCourierById(Long id);


    Mono<Courier> getCourierByUserId(String id);
}
