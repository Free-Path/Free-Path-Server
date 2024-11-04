package com.freepath.place.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.freepath.place.domain.Place;
import com.freepath.place.repository.PlaceRepository;

@Component
public class PlaceReader {

    private final PlaceRepository placeRepository;

    public PlaceReader(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place readById(Long id) {
        return placeRepository.readById(id);
    }

    public List<Place> readAll() {
        return placeRepository.readAll();
    }
}
