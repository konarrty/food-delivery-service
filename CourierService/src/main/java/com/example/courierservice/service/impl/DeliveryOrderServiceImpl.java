package com.example.courierservice.service.impl;

import com.example.courierservice.mapper.OrderMapper;
import com.example.courierservice.model.DeliveryOrder;
import com.example.courierservice.repository.DeliveryOrderRepository;
import com.example.courierservice.service.CourierService;
import com.example.courierservice.service.DeliveryOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.DeliveryOrderDTO;
import org.example.commondtos.dto.UserJwtDTO;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    private final DeliveryOrderRepository deliveryOrderRepository;
    private final CourierService courierService;

    private final OrderMapper orderMapper;

    @Override
    public Flux<DeliveryOrder> getAllDeliveryOrders() {

        return deliveryOrderRepository.findAll();
    }

    @Override
    public Mono<DeliveryOrder> createDeliveryOrders(DeliveryOrder deliveryOrder, UserJwtDTO user) {

        return courierService.getCourierByUserId(user.getId()).map(u -> {

            deliveryOrder.setUserID(u.getUserId());
            return deliveryOrder;
        });

    }

    @Override
    public Mono<DeliveryOrder> patchDeliveryOrders(DeliveryOrderDTO newDeliveryOrders, Long id) {

        return deliveryOrderRepository
                .findById(id).map(deliveryOrder -> {
                    orderMapper.partialUpdate(deliveryOrder, newDeliveryOrders);
                    return deliveryOrder;
                }).flatMap(deliveryOrderRepository::save);
    }

    @Override
    @Transactional
    public Mono<Void> deleteDeliveryOrderByOrderId(Long id) {

        return deliveryOrderRepository.findById(id)
                .flatMap(o -> deliveryOrderRepository.deleteById(o.getOrderId()));
    }

    @Override
    public Mono<Boolean> existByOrderId(Long id) {

        return deliveryOrderRepository.existsById(id);
    }

    @Override
    public Mono<?> getDeliveryOrdersById(Long id) {

        return deliveryOrderRepository
                .findById(id).switchIfEmpty(Mono.error(new NoSuchEntityException("Ресторан не найден!")));
    }
}
