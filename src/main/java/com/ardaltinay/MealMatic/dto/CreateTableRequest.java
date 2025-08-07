package com.ardaltinay.MealMatic.dto;

import com.ardaltinay.MealMatic.enums.LocationEnum;

public record CreateTableRequest(Short number,
                                 LocationEnum location) {}
