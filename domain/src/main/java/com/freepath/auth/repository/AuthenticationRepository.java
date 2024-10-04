package com.freepath.auth.repository;

import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;

public interface AuthenticationRepository {

    Authentication create(NewAuthentication newAuthentication);

    Boolean verifySocialId(String socialId);
}
