package com.freepath.auth.repository;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;

public interface AuthenticationRepository {

    Authentication create(Long userId, NewAuthentication newAuthentication);

    Boolean verifySocialId(String socialId);

    Authentication findBySocialId(String socialId);

}
