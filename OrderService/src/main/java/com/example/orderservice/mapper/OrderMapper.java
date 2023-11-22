package com.example.orderservice.mapper;

import com.example.orderservice.model.Order;
import org.example.commondtos.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDTO);
}
