package com.example.clientnotificationservice.resolver.oAuth;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OAuth2User {

}