package com.freepath.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationJpaRepository extends JpaRepository<AuthenticationEntity, Long> {
    Boolean existsBySocialId(String socialId);
}
