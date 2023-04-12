package com.gwen.minibolt.dtos.userImplDTOs;

import lombok.Data;

import java.util.Date;

//save prev order and save orders
@Data
public class OrdersDto {
 private String foodName;
 private Double foodPrize;
 private Date timestamp;
 private String restaurantName;
}
