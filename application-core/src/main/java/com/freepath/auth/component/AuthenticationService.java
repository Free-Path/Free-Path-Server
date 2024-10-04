package com.freepath.auth.component;

import org.springframework.stereotype.Service;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;

@Service
public class AuthenticationService {

    private final AuthenticationAppender authenticationAppender;
    private final AuthenticationValidator authenticationValidator;

    public AuthenticationService(
        AuthenticationAppender authenticationAppender,
        AuthenticationValidator authenticationValidator
    ) {
        this.authenticationAppender = authenticationAppender;
        this.authenticationValidator = authenticationValidator;
    }

    public Authentication signUp(
        NewAuthentication newAuthentication
    ) {
        authenticationValidator.verify(newAuthentication);
        return authenticationAppender.append(newAuthentication);
    }
}
