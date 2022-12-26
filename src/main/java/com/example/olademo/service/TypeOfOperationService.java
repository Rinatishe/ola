package com.example.olademo.service;

import com.example.olademo.dto.ClientDto;
import com.example.olademo.dto.TypeOfOperationDto;
import com.example.olademo.entity.TypeOfOperation;
import com.example.olademo.repository.TypeOfOperationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOfOperationService {
    private final TypeOfOperationRepository typeOfOperationRepository;

    public TypeOfOperationService(TypeOfOperationRepository typeOfOperationRepository) {
        this.typeOfOperationRepository = typeOfOperationRepository;
    }


    public List<TypeOfOperationDto> getAllTypeOfOperation(){
        List<TypeOfOperation> typeOfOperationList = (List<TypeOfOperation>) typeOfOperationRepository.findAll();

        List<TypeOfOperationDto> typeOfOperationDtos = new ArrayList<>();
        for (TypeOfOperation entry: typeOfOperationList) {
            TypeOfOperationDto dto = new TypeOfOperationDto();
            dto.uid = entry.getTypeOfOperationUid().toString();
            dto.operationName = entry.getOperationName();
            dto.peculiarities = entry.getPeculiarities();
            typeOfOperationDtos.add(dto);
        }
        return typeOfOperationDtos;
    }
}
