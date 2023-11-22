package com.example.orderservice.service;

import com.example.GreetingServiceGrpc;
import com.example.GreetingServiceOuterClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoobarService {

    private GreetingServiceGrpc.GreetingServiceBlockingStub myServiceStub;

    public String receiveGreeting(String name) {
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName(name)
                .build();

        return myServiceStub.greeting(request).getGreeting();
    }

}