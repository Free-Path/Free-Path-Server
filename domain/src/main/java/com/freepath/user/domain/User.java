package com.freepath.user.domain;

public record User(
    Long id,
    String name,
    Gender gender,
    Integer age,
    String imageUrl
) {
}
