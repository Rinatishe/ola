package com.example.olademo.service;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Limits;
import com.example.olademo.entity.Operation;
import com.example.olademo.mapper.OperationMapper;
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
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private LimitsService limitsService;

    public UUID create(OperationDto dto){
        if(dto == null) return null;
        //update remainder in limit
        Limits limit = limitsService.getOneByAccountAndTypeAndCurrency(dto.accountUid, dto.operationCategoryUid, dto.currency);
        if(limit == null) return null;
        limit.setRemainder(limit.getRemainder() - dto.sum);
        limitsService.save(limit);
        //save operation
        dto.limitSum = limit.getSum();
        Operation operation = operationMapper.mapDto(dto, new Operation());
        operation.setLimitExceed(limit.getRemainder() < 0);
        operation = operationRepository.save(operation);
        return operation.getUid();
    }

    public List<OperationDto> getAllExceeded(UUID accountUid) {
        List<Operation> operations = operationRepository.findAllByAccountUidAndLimitExceedTrue(accountUid);
        List<OperationDto> dtos = new ArrayList<>();
        for (Operation operation : operations) {
            OperationDto dto = operationMapper.mapEntry(operation);
            dtos.add(dto);
        }
        return dtos;
    }
}
