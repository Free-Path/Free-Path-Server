package com.freepath.place.repository;

import java.util.List;

import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Place;

public interface PlaceRepository {

    Place create(NewPlace newPlace);

    List<Place> createAll(List<NewPlace> newPlaces);

    Place readById(Long id);

    List<Place> readAll();

}
