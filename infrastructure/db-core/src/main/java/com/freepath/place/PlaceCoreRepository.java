package com.freepath.place;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Place;
import com.freepath.place.repository.PlaceRepository;

@Repository
public class PlaceCoreRepository implements PlaceRepository {

    private final PlaceJpaRepository placeJpaRepository;

    public PlaceCoreRepository(PlaceJpaRepository placeJpaRepository) {
        this.placeJpaRepository = placeJpaRepository;
    }

    public Place create(NewPlace newPlace) {
        PlaceEntity placeEntity = new PlaceEntity(newPlace);
        return placeJpaRepository.save(placeEntity).toPlace();
    }

    public List<Place> createAll(List<NewPlace> newPlaces) {
        List<PlaceEntity> placeEntities = newPlaces.stream().map(PlaceEntity::new).toList();
        return placeJpaRepository.saveAll(placeEntities).stream().map(PlaceEntity::toPlace).toList();
    }

    public Place readById(Long id) {
        return placeJpaRepository.findById(id).orElseThrow().toPlace();
    }

    public List<Place> readAll() {
        return placeJpaRepository.findAll().stream().map(PlaceEntity::toPlace).toList();
    }

}
