package com.example.gateway.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJwtDTO {

    @JsonProperty(value = "sub")
    private String id;

    @JsonProperty(value = "preferred_username")
    private String username;

    private String email;
}
