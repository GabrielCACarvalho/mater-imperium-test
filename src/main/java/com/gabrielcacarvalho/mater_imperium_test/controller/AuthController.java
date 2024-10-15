package com.gabrielcacarvalho.mater_imperium_test.controller;

import com.gabrielcacarvalho.mater_imperium_test.dto.LoginDTO;
import com.gabrielcacarvalho.mater_imperium_test.dto.LoginResponseDTO;
import com.gabrielcacarvalho.mater_imperium_test.service.AuthenticationService;
import com.gabrielcacarvalho.mater_imperium_test.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginDTO dto) {
        String jwtToken = jwtService.generateToken(authenticationService.authenticate(dto));

        LoginResponseDTO loginResponse = new LoginResponseDTO();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
