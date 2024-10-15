package com.gabrielcacarvalho.mater_imperium_test.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private long expiresIn;
}
