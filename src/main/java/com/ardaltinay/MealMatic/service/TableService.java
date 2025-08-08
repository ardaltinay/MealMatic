package com.ardaltinay.MealMatic.service;

import com.ardaltinay.MealMatic.converter.TableConverter;
import com.ardaltinay.MealMatic.dto.CreateTableRequest;
import com.ardaltinay.MealMatic.entity.Table;
import com.ardaltinay.MealMatic.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TableService {
    private final TableRepository tableRepository;
    private final TableConverter tableConverter;

    public ModelAndView getAllTablesWithPagination(int page, int size) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Table> tablesPage = tableRepository.findAll(PageRequest.of(page, size, Sort.by("number").ascending()));
        modelAndView.addObject("tablesPage", tablesPage);
        modelAndView.addObject("currentPage", page);
        modelAndView.setViewName("tables");
        return modelAndView;
    }

    public Map<String, Object> createTable(CreateTableRequest createTableRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            tableRepository.save(tableConverter.toEntity(createTableRequest));
            response.put("result", "success");
        } catch (Exception e) {
            response.put("result", "error");
            log.error("Error while creating table object!");
        }

        return response;
    }
}
