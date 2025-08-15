package com.ardaltinay.MealMatic.controller;

import com.ardaltinay.MealMatic.dto.CreateEmployeeRequest;
import com.ardaltinay.MealMatic.dto.CreateProductRequest;
import com.ardaltinay.MealMatic.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ModelAndView admin(ModelAndView modelAndView) {
        return adminService.getProducts(modelAndView);
    }

    @PostMapping("/create-employee")
    @ResponseBody
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request) {
        adminService.createEmployee(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create-product")
    @ResponseBody
    public Map<String, Object> createProduct(@ModelAttribute CreateProductRequest request) {
        return adminService.createProduct(request);
    }

    @GetMapping("/get-products")
    public ModelAndView getProducts(ModelAndView modelAndView) {
        return adminService.getProducts(modelAndView);
    }

    @GetMapping("/get-product/{id}")
    @ResponseBody
    public Map<String, Object> getProduct(@PathVariable String id) {
        return adminService.getProduct(id);
    }
}
