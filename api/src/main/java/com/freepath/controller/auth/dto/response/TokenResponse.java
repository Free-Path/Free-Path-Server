package com.freepath.controller.auth.dto.response;

import com.freepath.token.domain.Token;

public record TokenResponse(String accessToken, String refreshToken) {
    public static TokenResponse from(Token token) {
        return new TokenResponse(token.accessToken(), token.refreshToken());
    }
}
