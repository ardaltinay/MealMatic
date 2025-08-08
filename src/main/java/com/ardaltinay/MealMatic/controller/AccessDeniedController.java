package com.ardaltinay.MealMatic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/access-denied")
public class AccessDeniedController {
    @GetMapping
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }
}
