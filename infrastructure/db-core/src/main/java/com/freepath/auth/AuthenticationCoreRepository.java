package com.freepath.auth;

import org.springframework.stereotype.Repository;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.repository.AuthenticationRepository;

@Repository
public class AuthenticationCoreRepository implements AuthenticationRepository {

    private final AuthenticationJpaRepository authenticationJpaRepository;

    public AuthenticationCoreRepository(AuthenticationJpaRepository authenticationJpaRepository) {
        this.authenticationJpaRepository = authenticationJpaRepository;
    }

    public Authentication create(NewAuthentication newAuthentication) {
        AuthenticationEntity authenticationEntity = new AuthenticationEntity(newAuthentication);
        return authenticationJpaRepository.save(authenticationEntity).toAuthentication();
    }

    public Boolean verifySocialId(String socialId) {
        return authenticationJpaRepository.existsBySocialId(socialId);
    }
}
