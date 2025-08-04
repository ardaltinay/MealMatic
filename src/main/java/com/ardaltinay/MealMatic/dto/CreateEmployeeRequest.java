package com.ardaltinay.MealMatic.dto;

import com.ardaltinay.MealMatic.enums.RoleEnum;

import java.time.LocalDate;

public record CreateEmployeeRequest(String tckn,
                                    String name,
                                    String surname,
                                    String pass,
                                    String phone,
                                    LocalDate dateOfBirth,
                                    RoleEnum role) {
}
