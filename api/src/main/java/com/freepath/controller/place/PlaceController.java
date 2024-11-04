package com.freepath.controller.place;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freepath.controller.place.dto.PlaceResponse;
import com.freepath.place.component.PlaceService;
import com.freepath.place.domain.Place;
import com.freepath.support.response.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "관광지")
@RequestMapping("/v1/places")
@RestController
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Operation(summary = "관광지 목록 조회")
    @GetMapping
    public ApiResponse<List<PlaceResponse>> getPlaces() {
        List<Place> places = placeService.findAll();
        return ApiResponse.success(PlaceResponse.listFrom(places));
    }

    @Operation(summary = "관광지 상세 조회")
    @GetMapping("/{id}")
    public ApiResponse<PlaceResponse> getPlace(@PathVariable Long id) {
        Place place = placeService.findById(id);
        return ApiResponse.success(PlaceResponse.from(place));
    }
}
