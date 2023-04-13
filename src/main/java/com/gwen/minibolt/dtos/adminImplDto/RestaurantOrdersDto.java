package com.gwen.minibolt.dtos.adminImplDto;

import lombok.Data;

import java.util.Date;
@Data
public class RestaurantOrdersDto {
    private String foodName;
    private Double foodPrize;
    private Date timestamp;
    private String restaurantName;
}
