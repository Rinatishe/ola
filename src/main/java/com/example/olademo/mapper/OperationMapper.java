package com.example.olademo.mapper;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OperationMapper {

    public Operation mapDto(OperationDto dto, Operation entry){
        if(dto == null || entry == null) return null;
        entry.setTypeOfOperationUid(UUID.fromString(dto.typeOfOperationUid));
        entry.setAccountsUid(UUID.fromString(dto.accountUid));
        entry.setSum(dto.sum);
        entry.setCurrency(dto.currency);
        entry.setTheDate(dto.theDate);
        entry.setLimitExceed(dto.limitExceed);
        return entry;
    }

    public OperationDto mapEntry(Operation entry){
        if(entry == null) return null;
        OperationDto dto = new OperationDto();
        dto.uid = entry.getUid().toString();
        dto.typeOfOperationUid = entry.getTypeOfOperationUid().toString();
        dto.accountUid = entry.getAccountsUid().toString();
        dto.sum = entry.getSum();
        dto.currency = entry.getCurrency();
        dto.theDate = entry.getTheDate();
        dto.limitExceed = entry.getLimitExceed();
        return dto;
    }
}
