package com.freepath.auth.component;

import org.springframework.stereotype.Component;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.repository.AuthenticationRepository;

@Component
public class AuthenticationAppender {

    private final AuthenticationRepository authenticationRepository;

    public AuthenticationAppender(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public Authentication append(NewAuthentication newAuthentication) {
        return authenticationRepository.create(newAuthentication);
    }
}
