package com.freepath.user.domain;

public record NewUser(
    String name,
    String nickname,
    Gender gender,
    String ageRange,
    String imageUrl
) {
}
