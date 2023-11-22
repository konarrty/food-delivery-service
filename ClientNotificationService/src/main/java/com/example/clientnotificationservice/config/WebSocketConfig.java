//package com.example.clientnotificationservice.config;
//
//import com.example.clientnotificationservice.dto.UserJwtDTO;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.SimpMessageType;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import java.util.Base64;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new ChannelInterceptor() {
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//
//                if (accessor.getCommand() == null || !accessor.getCommand().getMessageType().equals(SimpMessageType.SUBSCRIBE))
//                    return message;
//
//                String[] chunks = accessor.getFirstNativeHeader("Authorization").substring(7).split("\\.");
//                Base64.Decoder decoder = Base64.getUrlDecoder();
//
//                String payload = new String(decoder.decode(chunks[1]));
//                UserJwtDTO userJwtDTO;
//                try {
//                    userJwtDTO = new ObjectMapper().readValue(payload, UserJwtDTO.class);
//
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.err.println(userJwtDTO.getId() + " " + accessor.getDestination());
//                return message;
//            }
//        });
//    }
//
//
//}