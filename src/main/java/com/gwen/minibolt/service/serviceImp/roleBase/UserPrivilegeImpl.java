package com.gwen.minibolt.service.serviceImp.roleBase;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.OrderDto;
import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.repository.OrderItemRepository;
import com.gwen.minibolt.repository.OrderRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.ServiceInt.roleBase.UserPrivilege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class UserPrivilegeImpl implements UserPrivilege {
    private final RestaurantRepository restaurantRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ApiMapper apiMapper;

    @Override
    public RestaurantDto rateRestaurant(Long restaurantId, Double rating) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            //TODO:: do some calculation here
            restaurant.setRating(rating);
            return apiMapper.restaurantToRestaurantDto(restaurantRepository.save(restaurant));
        }).orElseThrow();
    }

    @Override
    public OrderItemDto placeOrderItem(OrderItemDto orderItemDto) {
        var orderItem = apiMapper.orderItemDtoToOrderItem(orderItemDto);
        var newOrderItem = orderItemRepository.save(orderItem);
        return apiMapper.orderItemToOrderItemDto(newOrderItem);
    }

    /**
     * @param oderItems
     * @return
     */
    @Override
    public OrderDto placeOrder(List<OrderItemDto> oderItems) {
        Order order = new Order();
        orderRepository.save(order);
        var orderItems = oderItems.stream().map(orderItemDto -> {
            var orderItem = apiMapper.orderItemDtoToOrderItem(orderItemDto);
            orderItem.setOrder(order);
            return orderItemRepository.save(orderItem);
        }).toList();
        order.setOrderItems(orderItems);
        orderRepository.save(order);
        return apiMapper.orderToOrderDto(order);
    }

    @Override
    public Map<String, List<RestaurantDto>> getRestaurantGroupedByLocation() {
        return restaurantRepository.findAll().stream().collect(Collectors.groupingBy(Restaurant::getLocation,
                collectingAndThen(toList(), restaurants -> restaurants.stream().map(apiMapper::restaurantToRestaurantDto)
                        .toList())));
    }

    @Override
    public List<RestaurantDto> getRestaurantsByLocation(String location) {
        return restaurantRepository.findAllByLocation(location).stream().map(apiMapper::restaurantToRestaurantDto)
                .toList();
    }

    @Override
    public Object ownARestaurant(Object ownershipDetails) {
        return null;
    }

    @Override
    public ORDER_STATUS getOrderStatus(Long orderId) {
        return orderRepository.findById(orderId).map(Order::getStatus)
                .orElseThrow();
    }

    @Override
    public List<MenuDto> getRestaurantMenuAndFoodPrices(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).stream()
                .flatMap(restaurant -> restaurant.getMenus().stream().map(apiMapper::menuToMenuDto).toList().stream())
                .toList();
    }

    @Override
    public List<RestaurantDto> getRestaurantsByStatusAndLocation(GENERAL_STATUS status, String location) {
        return restaurantRepository.findAllByStatusAndLocation(status, location)
                .stream().map(apiMapper::restaurantToRestaurantDto)
                .toList();
    }

    @Override
    public List<MenuDto> getRestaurantMenuByStatus(Long restaurantId, GENERAL_STATUS status) {
        return restaurantRepository.findByIdAndStatus(restaurantId, status)
                .map(restaurant -> restaurant.getMenus().stream().map(apiMapper::menuToMenuDto).toList())
                .orElseThrow();
    }

    @Override
    public List<RestaurantDto> getRestaurantsByStatus(GENERAL_STATUS status) {
        return restaurantRepository.findAllByStatus(status)
                .stream().map(apiMapper::restaurantToRestaurantDto)
                .toList();
    }
}
