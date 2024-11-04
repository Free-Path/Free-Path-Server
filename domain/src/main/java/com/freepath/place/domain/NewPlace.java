package com.freepath.place.domain;

import java.time.LocalDateTime;

public record NewPlace(
    String name,
    String description,
    Thumbnail thumbnail,
    LocalDateTime startAt,
    LocalDateTime endAt,
    Address address,
    Double latitude,
    Double longitude,
    boolean isBarrierFree
) {
}
