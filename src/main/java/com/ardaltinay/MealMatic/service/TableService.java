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

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TableService {
    private final TableRepository tableRepository;
    private final TableConverter tableConverter;

    public Map<String, Object> getAllTablesWithPagination(int page, int size) {
        Map<String, Object> response = new HashMap<>();
        Page<Table> tablesPage = tableRepository.findAll(PageRequest.of(page, size, Sort.by("number").ascending()));
        response.put("tablesPage", tablesPage);
        response.put("currentPage", page);
        return response;
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
