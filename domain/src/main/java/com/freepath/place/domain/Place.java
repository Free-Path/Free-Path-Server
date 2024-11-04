package com.freepath.place.domain;

import java.time.LocalDateTime;

public record Place(
    Long id,
    String name,
    String description,
    Thumbnail thumbnail,
    LocalDateTime startAt,
    LocalDateTime endAt,
    Address address,
    Double latitude,
    Double longitude,
    int likes,
    boolean isBarrierFree
) {
}
