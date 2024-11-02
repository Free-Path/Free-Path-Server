package com.freepath.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freepath.auth.domain.Authentication;

public interface AuthenticationJpaRepository extends JpaRepository<AuthenticationEntity, Long> {

    Boolean existsBySocialId(String socialId);

    Optional<Authentication> findBySocialId(String socialId);

}
