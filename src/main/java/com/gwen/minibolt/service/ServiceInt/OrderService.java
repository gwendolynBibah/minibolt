package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();

    OrderDto createOrder(OrderDto order);

    OrderDto getOrder(String id);

    void deleteOrder(String id);

    OrderDto updateOrder(String orderId, OrderDto orderDto);
}
