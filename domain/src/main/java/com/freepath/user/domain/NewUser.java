package com.freepath.user.domain;

public record NewUser(
    String name,
    Gender gender,
    Integer age,
    String imageUrl
) {
}
