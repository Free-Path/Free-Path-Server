package com.freepath.user.domain;

public record User(
    Long id,
    String name,
    String nickname,
    Gender gender,
    String ageRange,
    String imageUrl
) {
}
