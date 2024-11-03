package com.freepath.auth;

import org.springframework.stereotype.Repository;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.repository.AuthenticationRepository;
import com.freepath.error.ErrorException;
import com.freepath.error.ErrorType;

@Repository
public class AuthenticationCoreRepository implements AuthenticationRepository {

    private final AuthenticationJpaRepository authenticationJpaRepository;

    public AuthenticationCoreRepository(AuthenticationJpaRepository authenticationJpaRepository) {
        this.authenticationJpaRepository = authenticationJpaRepository;
    }

    public Authentication create(Long userId, NewAuthentication newAuthentication) {
        AuthenticationEntity authenticationEntity = new AuthenticationEntity(userId, newAuthentication);
        return authenticationJpaRepository.save(authenticationEntity).toAuthentication();
    }

    public Boolean verifySocialId(String socialId) {
        return authenticationJpaRepository.existsBySocialId(socialId);
    }

    public Authentication findBySocialId(String socialId) {
        return authenticationJpaRepository.findBySocialId(socialId)
            .orElseThrow(() -> new ErrorException(ErrorType.NOT_FOUND_DATA, socialId));
    }

}
