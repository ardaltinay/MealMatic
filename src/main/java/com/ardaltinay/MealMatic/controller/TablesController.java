package com.ardaltinay.MealMatic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tables")
public class TablesController {
    @GetMapping
    public ModelAndView getTables(ModelAndView modelAndView) {
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
