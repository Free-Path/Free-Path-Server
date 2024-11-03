package com.freepath.auth.component;

import org.springframework.stereotype.Service;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.CredentialSocial;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.token.domain.Token;

@Service
public class AuthenticationService {

    private final AuthenticationProcessor authenticationProcessor;

    private final AuthenticationValidator authenticationValidator;

    public AuthenticationService(AuthenticationProcessor authenticationProcessor,
            AuthenticationValidator authenticationValidator) {
        this.authenticationProcessor = authenticationProcessor;
        this.authenticationValidator = authenticationValidator;
    }

    public Authentication signUp(Long userId, NewAuthentication newAuthentication) {
        authenticationValidator.verify(newAuthentication);
        return authenticationProcessor.append(userId, newAuthentication);
    }

    public Token login(CredentialSocial credentialSocial) {
        return authenticationProcessor.login(credentialSocial);
    }

}
