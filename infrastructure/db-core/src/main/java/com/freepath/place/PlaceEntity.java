package com.freepath.place;

import java.time.LocalDateTime;

import com.freepath.BaseEntity;
import com.freepath.place.domain.Address;
import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Place;
import com.freepath.place.domain.Thumbnail;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_place")
public class PlaceEntity extends BaseEntity {

    private String name;

    private String description;

    private String thumbnailUrl1;

    private String thumbnailUrl2;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String address;

    private String detailAddress;

    private Double latitude;

    private Double longitude;

    private int likes;

    private boolean isBarrierFree;

    protected PlaceEntity() {
    }

    public PlaceEntity(NewPlace newPlace) {
        this.name = newPlace.name();
        this.description = newPlace.description();
        this.thumbnailUrl1 = newPlace.thumbnail().url1();
        this.thumbnailUrl2 = newPlace.thumbnail().url2();
        this.startAt = newPlace.startAt();
        this.endAt  = newPlace.endAt();
        this.address = newPlace.address().detail() + newPlace.address().value();
        this.latitude = newPlace.latitude();
        this.longitude = newPlace.longitude();
        this.isBarrierFree = newPlace.isBarrierFree();
    }

    public Place toPlace() {
        return new Place(
            this.getId(),
            this.name,
            this.description,
            new Thumbnail(
                this.thumbnailUrl1,
                this.thumbnailUrl2
            ),
            this.startAt,
            this.endAt,
            new Address(
                this.address,
                this.detailAddress
            ),
            this.latitude,
            this.longitude,
            this.likes,
            this.isBarrierFree
        );
    }
}
