package com.freepath.user;

public record NewUser(
    String name,
    Gender gender,
    Integer age,
    String imageUrl
) {
}
