package com.example.clientnotificationservice.converter;

import com.example.clientnotificationservice.dto.SubscriptionData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@ReadingConverter
public class BytesToSubscriptionDataConverter implements Converter<byte[], SubscriptionData> {

    private final Jackson2JsonRedisSerializer<SubscriptionData> serializer;

    public BytesToSubscriptionDataConverter() {

        serializer = new Jackson2JsonRedisSerializer<SubscriptionData>(SubscriptionData.class);
//    serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public SubscriptionData convert(byte[] value) {
        return serializer.deserialize(value);
    }
}