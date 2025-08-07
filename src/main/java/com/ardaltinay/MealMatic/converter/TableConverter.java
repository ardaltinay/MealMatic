package com.ardaltinay.MealMatic.converter;

import com.ardaltinay.MealMatic.dto.CreateTableRequest;
import com.ardaltinay.MealMatic.entity.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TableConverter {

    public Table toEntity(CreateTableRequest request) {
        return Table.builder()
                .number(request.number())
                .location(request.location())
                .bill(BigDecimal.ZERO)
                .isAvailable(true)
                .build();
    }
}
