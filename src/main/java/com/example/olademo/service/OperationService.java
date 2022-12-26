package com.example.olademo.service;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Limits;
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
    @Autowired
    private LimitsService limitsService;

    public UUID create(OperationDto dto){
        if(dto == null) return null;
        Limits limit = limitsService.getOneByAccountAndTypeAndCurrency(dto.accountUid, dto.typeOfOperationUid, dto.currency);
        if(limit == null) return null;
        limit.getSum();
        Operation operation = operationMapper.mapDto(dto, new Operation());
        operation = operationRepository.save(operation);
        return operation.getUid();
    }
}
