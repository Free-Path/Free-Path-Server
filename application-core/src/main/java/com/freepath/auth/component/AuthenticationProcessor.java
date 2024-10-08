package com.freepath.auth.component;

import org.springframework.stereotype.Component;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.CredentialSocial;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.token.domain.Token;
import com.freepath.auth.repository.AuthenticationRepository;
import com.freepath.token.repository.TokenRepository;

@Component
public class AuthenticationProcessor {

    private final AuthenticationRepository authenticationRepository;
    private final TokenRepository tokenRepository;

    public AuthenticationProcessor(AuthenticationRepository authenticationRepository, TokenRepository tokenRepository) {
        this.authenticationRepository = authenticationRepository;
        this.tokenRepository = tokenRepository;
    }

    public Authentication append(Long userId, NewAuthentication newAuthentication) {
        return authenticationRepository.create(userId, newAuthentication);
    }

    public Token login(CredentialSocial credentialSocial) {
        Authentication authentication = authenticationRepository.findBySocialId(credentialSocial.socialId());
        return tokenRepository.create(authentication);
    }
}
