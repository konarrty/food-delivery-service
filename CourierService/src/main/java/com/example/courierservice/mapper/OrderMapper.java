package com.example.courierservice.mapper;

import com.example.courierservice.model.DeliveryOrder;
import org.example.commondtos.dto.DeliveryOrderDTO;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    DeliveryOrder toEntity(DeliveryOrderDTO deliveryOrderDTO);

    DeliveryOrderDTO toDto(DeliveryOrder deliveryOrder);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(
            @MappingTarget DeliveryOrder deliveryOrder,
            DeliveryOrderDTO deliveryOrderDTO
    );
}
