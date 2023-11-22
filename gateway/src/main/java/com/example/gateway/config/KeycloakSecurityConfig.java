package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebFluxSecurity
public class KeycloakSecurityConfig implements WebMvcConfigurer {

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.GET, "eureka/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(oAuth2 ->
                        oAuth2.jwt(Customizer.withDefaults()));

        return http.build();

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}