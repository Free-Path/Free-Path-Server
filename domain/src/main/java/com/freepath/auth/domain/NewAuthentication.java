package com.freepath.auth.domain;

public record NewAuthentication(
    Long userId,
    String socialId,
    SocialType socialType
) {
}
