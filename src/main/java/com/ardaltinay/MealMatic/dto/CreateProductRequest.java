package com.ardaltinay.MealMatic.dto;

import com.ardaltinay.MealMatic.enums.ProductCategoryEnum;
import com.ardaltinay.MealMatic.enums.ProductTypeEnum;

import java.math.BigDecimal;

public record CreateProductRequest(String name,
                                   String description,
                                   BigDecimal price,
                                   ProductTypeEnum type,
                                   ProductCategoryEnum category) {
}
