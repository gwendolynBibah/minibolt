package com.gwen.minibolt.dtos.restaurantimplDto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomersAndTheirOrdersDto {
    private String customerName;
    private String restaurantName;
    private String foodName;
    private Double foodPrize;
    private Date timestamp;
}
