package com.example.customerservice.config;

import com.example.customerservice.annotation.OAuth2UserProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final OAuth2UserProcessor oAuth2UserProcessor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        resolvers.add(oAuth2UserProcessor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}