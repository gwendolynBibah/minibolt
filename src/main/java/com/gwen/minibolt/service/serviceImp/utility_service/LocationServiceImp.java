package com.gwen.minibolt.service.serviceImp.utility_service;

import com.gwen.minibolt.dto.TownDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.repository.TownRepository;
import com.gwen.minibolt.service.ServiceInt.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  LocationServiceImp implements LocationService {

    private final TownRepository townRepository;
    private final ApiMapper mapper;
    @Override
    public List<TownDto> getLocations() {
        return townRepository.findAll().stream().map(mapper::townToTownDto).toList();
    }
}