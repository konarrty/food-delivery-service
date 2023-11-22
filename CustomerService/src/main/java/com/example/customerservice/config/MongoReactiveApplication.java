package com.example.customerservice.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Sinks;

@EnableReactiveMongoRepositories
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

    @Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "reactive";
    }


}