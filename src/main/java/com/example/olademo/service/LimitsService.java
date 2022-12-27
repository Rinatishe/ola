package com.example.olademo.service;

import com.example.olademo.dto.LimitDto;
import com.example.olademo.entity.Limits;
import com.example.olademo.repository.LimitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class LimitsService {
    @Autowired
    private LimitsRepository limitsRepository;

    public Limits getOneByAccountAndTypeAndCurrency(String accountUid, String typeUid, String currency){
        return limitsRepository.findByAccountUidAndTypeOfOperationUidAndCurrency(UUID.fromString(accountUid), UUID.fromString(typeUid), currency);
    }

    public UUID save(Limits entry){
        entry = limitsRepository.save(entry);
        return entry.getUid();
    }

    public UUID save(LimitDto dto){
        if(dto == null) return null;
        Limits limit = limitsRepository.findById(UUID.fromString(dto.uid)).get();
        if(limit == null) return null;
        //map
        Integer difference = dto.sum - limit.getSum();
        limit.setSum(dto.sum);
        limit.setCurrency(dto.currency);
        limit.setDate(new Date());
        limit.setRemainder(limit.getRemainder() + difference);
        limitsRepository.save(limit);
        return limit.getUid();
    }
}
