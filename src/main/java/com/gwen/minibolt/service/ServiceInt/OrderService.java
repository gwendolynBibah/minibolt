package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();

    OrderDto createOrder(OrderDto order);

    OrderDto getOrder(long id);

    void deleteOrder(Long id);

    OrderDto updateOrder(Long orderId, OrderDto orderDto);
}
