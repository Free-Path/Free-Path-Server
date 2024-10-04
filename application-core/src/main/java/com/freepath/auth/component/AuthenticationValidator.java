package com.freepath.auth.component;

import org.springframework.stereotype.Component;

import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.repository.AuthenticationRepository;
import com.freepath.error.ErrorException;
import com.freepath.error.ErrorType;

@Component
public class AuthenticationValidator {

    private final AuthenticationRepository authenticationRepository;

    public AuthenticationValidator(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public void verify(NewAuthentication newAuthentication) {
        if (authenticationRepository.verifySocialId(newAuthentication.socialId())) {
            throw new ErrorException(ErrorType.DUPLICATED_USER);
        }
    }
}
