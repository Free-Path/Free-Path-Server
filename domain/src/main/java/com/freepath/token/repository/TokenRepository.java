package com.freepath.token.repository;

import com.freepath.auth.domain.Authentication;
import com.freepath.token.domain.Token;

public interface TokenRepository {

    Token create(Authentication authentication);

}
