package com.example.orderservice.config;

import lombok.RequiredArgsConstructor;
import org.example.commondtos.resolver.OAuth2UserProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    OAuth2UserProcessor oAuth2UserProcessor() {

        return new OAuth2UserProcessor();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(oAuth2UserProcessor());
    }
}
