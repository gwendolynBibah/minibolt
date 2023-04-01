package com.gwen.minibolt.controllers;

import com.gwen.minibolt.dto.TownDto;
import com.gwen.minibolt.service.ServiceInt.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public List<TownDto> getLocations() {
        return this.locationService.getLocations();
    }
}
