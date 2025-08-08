package com.ardaltinay.MealMatic.controller;

import com.ardaltinay.MealMatic.dto.CreateTableRequest;
import com.ardaltinay.MealMatic.service.TableService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/tables")
@RequiredArgsConstructor
public class TablesController {

    private final TableService tableService;

    @GetMapping
    public ModelAndView getTables(ModelAndView modelAndView,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size) {
        return tableService.getAllTablesWithPagination(page, size);
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createTable(@RequestBody CreateTableRequest request) {
        return tableService.createTable(request);
    }
}
