package com.gabrielcacarvalho.mater_imperium_test.service;

import com.gabrielcacarvalho.mater_imperium_test.dto.LoginDTO;
import com.gabrielcacarvalho.mater_imperium_test.entity.User;
import com.gabrielcacarvalho.mater_imperium_test.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public User authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
