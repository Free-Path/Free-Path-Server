package com.freepath.controller.place.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.freepath.place.domain.Place;

public record PlaceResponse(
    Long id,
    String name,
    String description,
    String thumbnailUrl1,
    String thumbnailUrl2,
    LocalDateTime startAt,
    LocalDateTime endAt,
    String value,
    String detail,
    Double latitude,
    Double longitude,
    int likes,
    boolean isBarrierFree
) {
    public static PlaceResponse from(Place place) {
        return new PlaceResponse(
            place.id(),
            place.name(),
            place.description(),
            place.thumbnail().url1(),
            place.thumbnail().url2(),
            place.startAt(),
            place.endAt(),
            place.address().value(),
            place.address().detail(),
            place.latitude(),
            place.longitude(),
            place.likes(),
            place.isBarrierFree()
        );
    }

    public static List<PlaceResponse> listFrom(List<Place> places) {
        return places.stream()
            .map(PlaceResponse::from)
            .toList();
    }
}
