package com.ardaltinay.MealMatic.service;

import com.ardaltinay.MealMatic.converter.EmployeeConverter;
import com.ardaltinay.MealMatic.converter.ProductConverter;
import com.ardaltinay.MealMatic.dto.CreateEmployeeRequest;
import com.ardaltinay.MealMatic.dto.CreateProductRequest;
import com.ardaltinay.MealMatic.dto.ProductDto;
import com.ardaltinay.MealMatic.entity.Product;
import com.ardaltinay.MealMatic.repository.EmployeeRepository;
import com.ardaltinay.MealMatic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;
    private final EmployeeConverter employeeConverter;
    private final ProductConverter productConverter;

    public void createEmployee(CreateEmployeeRequest request) {
        employeeRepository.save(employeeConverter.toEntity(request));
    }

    public Map<String, Object> createProduct(CreateProductRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            productRepository.save(productConverter.toEntity(request));
            map.put("success", true);
        } catch (Exception e) {
            log.error("Error while creating Product object!");
            map.put("success", false);
        }
        return map;
    }

    public ModelAndView getProducts(ModelAndView modelAndView) {
        List<ProductDto> products = productRepository.findAll()
                .stream()
                .map(productConverter::toDto)
                .toList();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    public Map<String, Object> getProduct(String id) {
        Map<String, Object> map = new HashMap<>();

        ProductDto productDto = productRepository.findById(UUID.fromString(id))
                .stream()
                .map(productConverter::toDto)
                .findFirst().orElseThrow(RuntimeException::new);

        map.put("product", productDto);
        map.put("success", true);
        return map;
    }
}
