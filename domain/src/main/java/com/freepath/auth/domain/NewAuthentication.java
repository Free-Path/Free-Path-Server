package com.freepath.auth.domain;

public record NewAuthentication(
    String socialId,
    SocialType socialType
) {
}
