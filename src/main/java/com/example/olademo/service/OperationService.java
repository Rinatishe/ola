package com.example.olademo.service;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Operation;
import com.example.olademo.mapper.OperationMapper;
import com.example.olademo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private OperationMapper operationMapper;


//    public List<OperationDto> getAllOperations(){
//        List<Operation> operationList = (List<Operation>) operationRepository.findAll();
//
//        List<OperationDto> operationDtos = new ArrayList<>();
//        for (Operation entry: operationList) {
//            OperationDto dto = operationMapper.mapEntry(entry);
//            operationDtos.add(dto);
//        }
//        return operationDtos;
//    }

    public UUID create(OperationDto dto){
        if(dto == null) return null;
        Operation operation = operationMapper.mapDto(dto, new Operation());
        operation = operationRepository.save(operation);
        return operation.getUid();
    }
}
