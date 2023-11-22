package com.example.courierservice.service.gRPC;

import com.example.CourierServiceGrpc;
import com.example.CourierServiceOuterClass;
import com.example.courierservice.service.DeliveryOrderService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class CourierGrpcService extends CourierServiceGrpc.CourierServiceImplBase {

    private final DeliveryOrderService orderService;

    @Override
    public void existById(CourierServiceOuterClass.OrderIdRequest request,
                          StreamObserver<CourierServiceOuterClass.OrderIdResponse> responseObserver) {

        var reply = CourierServiceOuterClass
                .OrderIdResponse.newBuilder()
                .setIsExist(Boolean.TRUE.equals(orderService.existByOrderId(request.getOrderId()).block()))
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
