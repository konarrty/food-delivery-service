package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoApplication.class)
                .web(false)
                .run(args);
    }

    @Bean
    public Consumer<Message<String>> listen() {
        return message -> {
            String queue = -message.getHeaders().get(AmqpHeaders.CONSUMER_QUEUE);
            System.out.println(in + " received from queue " + queue);
        };
    }

}
}
