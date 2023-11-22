package com.example.clientnotificationservice.resolver.oAuth;

import com.example.clientnotificationservice.dto.UserJwtDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Base64;

@Component
public class OAuth2UserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(OAuth2User.class);
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String auth = webRequest.getHeader("Authorization");

        if (auth == null)
            return null;

        String[] chunks = auth.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));

        return new ObjectMapper().readValue(payload, UserJwtDTO.class);
    }
}