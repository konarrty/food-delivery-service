package com.example.clientnotificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.FluxSink;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionData implements Serializable {

    public FluxSink<ServerSentEvent<String>> fluxSink;

}
