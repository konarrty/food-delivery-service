package com.example.clientnotificationservice.converter;

import com.example.clientnotificationservice.dto.SubscriptionData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@WritingConverter
public class SubscriptionDataToBytesConverter implements Converter<SubscriptionData, byte[]> {

  private final Jackson2JsonRedisSerializer<SubscriptionData> serializer;

  public SubscriptionDataToBytesConverter() {

    serializer = new Jackson2JsonRedisSerializer<SubscriptionData>(SubscriptionData.class);
//    serializer.se.setObjectMapper(new ObjectMapper());
  }

  @Override
  public byte[] convert(SubscriptionData value) {
    return serializer.serialize(value);
  }


}
