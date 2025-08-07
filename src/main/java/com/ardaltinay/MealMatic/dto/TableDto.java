package com.ardaltinay.MealMatic.dto;

import com.ardaltinay.MealMatic.enums.LocationEnum;

import java.math.BigDecimal;

public record TableDto(Short number,
                       LocationEnum location,
                       BigDecimal bill,
                       Boolean isAvailable) {
}
