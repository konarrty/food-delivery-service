package com.example.courierservice.service.impl;

import com.example.courierservice.model.Courier;
import com.example.courierservice.repository.CourierRepository;
import com.example.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.CourierDTO;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Override
    public Flux<Courier> getAllCouriers(int page) {

        return courierRepository.findAll();
    }

    @Override
    public Mono<Courier> createCourier(Courier courier) {

        return courierRepository.save(courier);
    }

    @Override
    public Mono<Courier> patchCouriers(CourierDTO newCourier, Long id) {

        return courierRepository
                .findById(id)
                .map(c -> copyCourierProperties(c, newCourier))
                .flatMap(courierRepository::save);
    }

    @Override
    public Mono<Void> deleteCourier(Long id) {

        return courierRepository.deleteById(id);
    }

    @Override
    public Mono<Courier> getCourierById(Long id) {

        return courierRepository
                .findById(id)
                .switchIfEmpty(
                        Mono.error(new NoSuchEntityException("Курьер не найден!")));

    }

    @Override
    public Mono<Courier> getCourierByUserId(String userId) {

        return courierRepository
                .findByUserId(UUID.fromString(userId))
                .switchIfEmpty(
                        Mono.error(new NoSuchEntityException("Курьер не найден!")));


    }

    public Courier copyCourierProperties(Courier courier, CourierDTO newCourier) {
        BeanUtils.copyProperties(courier, newCourier);

        return courier;

    }
}
