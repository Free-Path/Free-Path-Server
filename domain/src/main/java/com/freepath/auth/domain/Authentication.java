package com.freepath.auth.domain;

public record Authentication(
    Long id,
    Long userId,
    String socialId,
    SocialType socialType
) {
}
