
package com.example.customerservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

@Configuration
public class RabbitConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
//        cachingConnectionFactory.setVirtualHost("cpp");
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }


    @Bean
    public Queue myQueue() {
        return new Queue("myQueue");
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("testExchanger", true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("testRoutingKey");
    }
    @Bean
    public RabbitTemplate rabbitTemplate() {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}