package com.example.gateway.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
public enum ERole implements GrantedAuthority {

    ROLE_CUSTOMER("Клиент"),

    ROLE_RESTAURANT("Ресторан"),

    ROLE_COURIER("Курьер");

    private String name;

    ERole(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name();
    }

}