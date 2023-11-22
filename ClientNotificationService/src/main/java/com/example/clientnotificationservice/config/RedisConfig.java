package com.example.clientnotificationservice.config;

import com.example.clientnotificationservice.converter.BytesToSubscriptionDataConverter;
import com.example.clientnotificationservice.converter.SubscriptionDataToBytesConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.*;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.Arrays;

@EnableRedisRepositories
@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(Arrays.asList(new BytesToSubscriptionDataConverter(), new SubscriptionDataToBytesConverter()));
    }
//
//    @Bean
//    public RedisCacheConfiguration cacheConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig(Thread.currentThread().getContextClassLoader())
//                .entryTtl(Duration.ofMinutes(60))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//    }
//
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration("itemCache",
//                        RedisCacheConfiguration.defaultCacheConfig(Thread.currentThread().getContextClassLoader()).entryTtl(Duration.ofMinutes(10)))
//                .withCacheConfiguration("customerCache",
//                        RedisCacheConfiguration.defaultCacheConfig(Thread.currentThread().getContextClassLoader()).entryTtl(Duration.ofMinutes(5)));
//    }
}
