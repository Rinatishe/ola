package com.example.olademo.service;

import com.example.olademo.dto.OperationCategoryDto;
import com.example.olademo.entity.OperationCategory;
import com.example.olademo.repository.OperationCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationCategoryService {
    private final OperationCategoryRepository operationCategoryRepository;

    public OperationCategoryService(OperationCategoryRepository operationCategoryRepository) {
        this.operationCategoryRepository = operationCategoryRepository;
    }


    public List<OperationCategoryDto> getAllTypeOfOperation(){
        List<OperationCategory> operationCategoryList = (List<OperationCategory>) operationCategoryRepository.findAll();

        List<OperationCategoryDto> operationCategoryDtos = new ArrayList<>();
        for (OperationCategory entry: operationCategoryList) {
            OperationCategoryDto dto = new OperationCategoryDto();
            dto.uid = entry.getUid().toString();
            dto.name = entry.getName();
            dto.description = entry.getDescription();
            operationCategoryDtos.add(dto);
        }
        return operationCategoryDtos;
    }
}
