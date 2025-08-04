package com.ardaltinay.MealMatic.converter;

import com.ardaltinay.MealMatic.dto.CreateEmployeeRequest;
import com.ardaltinay.MealMatic.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeConverter {

    private final PasswordEncoder passwordEncoder;

    public Employee toEntity(CreateEmployeeRequest request) {
        return Employee.builder()
                .phone(request.phone())
                .role(request.role())
                .tckn(request.tckn())
                .pass(passwordEncoder.encode(request.pass()))
                .dateOfBirth(request.dateOfBirth())
                .surname(request.surname())
                .name(request.name())
                .build();
    }
}
