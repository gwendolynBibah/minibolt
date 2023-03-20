package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.Dtos.CreateMenuDto;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.ServiceInt.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImp implements MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final ApiMapper mapper;

    @Override
    public List<MenuDto> getAllMenu() {
        return menuRepository.findAll()
                .stream().map(mapper::menuToMenuDto).toList();
    }

    @Override
    public List<MenuDto> getRestaurantMenuList(Long restaurantId){
        return this.menuRepository.findAllByRestaurantId(restaurantId)
                .stream().map(mapper::menuToMenuDto).toList();

    }
    @Override
    public Map<String, List<MenuDto>> getAllRestaurantAndTheirMenu(){
        return this.menuRepository.findAll().stream().map(mapper::menuToMenuDto)
                .collect(Collectors.groupingBy(menuDto->menuDto.restaurant().name()));

    }
    @Override
    public MenuDto createMenu(CreateMenuDto menuDto) {
        return mapper.menuToMenuDto(menuRepository.save(mapper.createMenuDtoToMenu(menuDto)));
    }

    @Override
    public MenuDto getMenu(long id) {
        return this.getMenuFromDatabase(id);
    }

    @Override
    public void deleteMenu(Long id) {
        if (Objects.nonNull(id)){
            this.menuRepository.deleteById(this.getMenuFromDatabase(id).id());
        }

    }
    private MenuDto getMenuFromDatabase(long id) {
        return menuRepository.findById(id).map(mapper::menuToMenuDto)
                .orElseThrow(() ->
                {
                    String message = String.format("Menu with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }

}
