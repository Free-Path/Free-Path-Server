package com.freepath.place.component;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Place;

@Service
public class PlaceService {

    private final PlaceAppender placeAppender;

    private final PlaceReader placeReader;

    public PlaceService(PlaceAppender placeAppender, PlaceReader placeReader) {
        this.placeAppender = placeAppender;
        this.placeReader = placeReader;
    }

    public Place create(NewPlace newPlace) {
        return placeAppender.append(newPlace);
    }

    public List<Place> createAll(List<NewPlace> newPlaces) {
        return placeAppender.appendAll(newPlaces);
    }

    public Place findById(Long id) {
        return placeReader.readById(id);
    }

    public List<Place> findAll() {
        return placeReader.readAll();
    }
}
