package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.Dtos.TownDto;

import java.util.List;

public interface LocationService {
    List<TownDto> getLocations();
}
