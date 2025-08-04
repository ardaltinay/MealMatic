package com.ardaltinay.MealMatic.service;

import com.ardaltinay.MealMatic.converter.EmployeeConverter;
import com.ardaltinay.MealMatic.dto.CreateEmployeeRequest;
import com.ardaltinay.MealMatic.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public void createEmployee(CreateEmployeeRequest request) {
        employeeRepository.save(employeeConverter.toEntity(request));
    }
}
