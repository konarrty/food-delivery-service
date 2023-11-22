package com.example.orderservice.service.gRPC;

import com.example.CourierServiceGrpc;
import com.example.CourierServiceOuterClass;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourierGrpcService {

    private CourierServiceGrpc.CourierServiceBlockingStub myServiceStub;

    @CircuitBreaker(name = "HELLO_SERVICE")
    public boolean existCourierByOrderId(Long id) {
        var request = CourierServiceOuterClass
                .OrderIdRequest.newBuilder()
                .setOrderId(id)
                .build();

        var response = myServiceStub.existById(request);

        return response.getIsExist();

    }
}
