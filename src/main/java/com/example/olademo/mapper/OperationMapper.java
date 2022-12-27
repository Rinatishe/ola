package com.example.olademo.mapper;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OperationMapper {

    public Operation mapDto(OperationDto dto, Operation entry){
        if(dto == null || entry == null) return null;
        entry.setOperationCategoryUid(UUID.fromString(dto.operationCategoryUid));
        entry.setAccountUid(UUID.fromString(dto.accountUid));
        entry.setSum(dto.sum);
        entry.setLimitSum(dto.limitSum);
        entry.setCurrency(dto.currency);
        entry.setDate(dto.date);
        entry.setLimitExceed(dto.limitExceed);
        return entry;
    }

    public OperationDto mapEntry(Operation entry){
        if(entry == null) return null;
        OperationDto dto = new OperationDto();
        dto.uid = entry.getUid().toString();
        dto.operationCategoryUid = entry.getOperationCategoryUid().toString();
        dto.accountUid = entry.getAccountUid().toString();
        dto.sum = entry.getSum();
        dto.limitSum = entry.getLimitSum();
        dto.currency = entry.getCurrency();
        dto.date = entry.getDate();
        dto.limitExceed = entry.getLimitExceed();
        return dto;
    }
}
