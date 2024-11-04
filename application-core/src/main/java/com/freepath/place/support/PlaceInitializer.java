package com.freepath.place.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.freepath.place.component.PlaceService;
import com.freepath.place.domain.Address;
import com.freepath.place.domain.NewPlace;
import com.freepath.place.domain.Thumbnail;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Component
public class PlaceInitializer implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(PlaceInitializer.class);

    private final PlaceService placeService;

    public PlaceInitializer(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("static/data/places.csv");
        InputStream inputStream = resource.getInputStream();
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            String[] nextLine;
            List<NewPlace> newPlaces = new ArrayList<>();
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Address address = new Address(nextLine[0], nextLine[1]);
                LocalDateTime startAt = LocalDateTime.of(2024, 11, 04, 9, 0);
                LocalDateTime endAt = LocalDateTime.of(2024, 11, 04, 18, 0);
                String name = nextLine[19];
                String description = "";
                Thumbnail thumbnail = new Thumbnail(nextLine[10], nextLine[11]);
                Double latitude = Double.valueOf(nextLine[13]);
                Double longitude = Double.valueOf(nextLine[14]);
                boolean isBarrierFree = true;
                NewPlace newPlace = new NewPlace(name, description, thumbnail, startAt, endAt, address, latitude, longitude, isBarrierFree);
                newPlaces.add(newPlace);
            }
            placeService.createAll(newPlaces);
        } catch (IOException e) {
            logger.error("IOException: {}", e.getMessage());
        } catch (CsvValidationException e) {
            logger.error("CsvValidationException: {}", e.getMessage());
        }
    }
}
