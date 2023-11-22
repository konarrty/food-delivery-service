package com.example.clientnotificationservice.controller;

import com.example.clientnotificationservice.dto.SubscriptionData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("notes")
@RequiredArgsConstructor
public class SseController {

    private final Map<String, SubscriptionData> subscriptionDataMap;

    @GetMapping(path = "/register/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> openSseStream(@PathVariable String id) {

        return Flux.create(fluxSink -> {

            log.info("create subscription for " + id);

            fluxSink.onCancel(
                    () -> {
                        subscriptionDataMap.remove(id);
                        log.info("subscription " + id + " was closed");
                    }

            );
            SubscriptionData subscriptionData = new SubscriptionData(fluxSink);
            subscriptionDataMap.put(id, subscriptionData);

            ServerSentEvent<String> helloEvent = ServerSentEvent.builder("Hello " + id).build();
            fluxSink.next(helloEvent);
        });
    }

}
