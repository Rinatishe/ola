package com.example.olademo.service;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Operation;
import com.example.olademo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OperationService {

@Autowired
private OperationRepository operationRepository;

//    private final OperationRepository operationRepository;
//
//    public OperationService(OperationRepository operationRepository){
//        this.operationRepository = operationRepository;
//    }

    public List<OperationDto> getAllOperations(){
        List<Operation> operationList = (List<Operation>) operationRepository.findAll();

        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation entry: operationList) {
            OperationDto dto = new OperationDto();
            dto.uid = entry.getUid().toString();
            dto.typeOfOperationUid = entry.getTypeOfOperationUid().toString();
            dto.accountsUid = entry.getAccountsUid().toString();
            dto.sum = entry.getSum();
            dto.theDate = entry.getTheDate();
            dto.limitExceed = entry.getLimitExceed();
            dto.currency = entry.getCurrency();
            operationDtos.add(dto);
        }
        return operationDtos;
    }

    public UUID create(OperationDto dto){
        if(dto == null) return null;
        Operation operation = new Operation();
        operation.setTypeOfOperationUid(dto.typeOfOperationUid);
        operation.setAccountsUid(dto.accountsUid);
        operation.setSum(dto.sum);
        operation.setTheDate(dto.theDate);
        operation.setLimitExceed(dto.limitExceed);
        operation.setCurrency(dto.currency);

        operation = operationRepository.save(operation);
        return operation.getUid();
    }
}
