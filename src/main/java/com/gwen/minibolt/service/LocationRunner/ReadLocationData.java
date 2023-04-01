package com.gwen.minibolt.service.LocationRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwen.minibolt.model.Regional;
import com.gwen.minibolt.model.Town;
import com.gwen.minibolt.repository.RegionalRepository;
import com.gwen.minibolt.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ReadLocationData implements CommandLineRunner {

    private final RegionalRepository regionalRepository;
    private final TownRepository townRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> example = objectMapper.readValue(new File(String.valueOf(new ClassPathResource("cities.json").getFile())), Map.class);
        example.forEach((regionalName, townNames) -> {
            Regional newRegion = new Regional();
            newRegion.setRegion(regionalName);
            if (this.regionalRepository.findByRegion(regionalName).isEmpty()) {
                Regional region = this.regionalRepository.save(newRegion);
                townNames.forEach(townName -> {
                    Town town = new Town();
                    town.setName(townName);
                    town.setRegion(region);
                    if (this.townRepository.findByName(townName).isEmpty()) {
                        this.townRepository.save(town);
                    }
                });
            }
        });
    }
}
