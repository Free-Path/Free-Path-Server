package com.freepath.place.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Place;
import com.freepath.place.repository.PlaceRepository;

@Component
public class PlaceAppender {

    private final PlaceRepository placeRepository;

    public PlaceAppender(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place append(NewPlace newPlace) {
        return placeRepository.create(newPlace);
    }

    public List<Place> appendAll(List<NewPlace> newPlaces) {
        return placeRepository.createAll(newPlaces);
    }

}
