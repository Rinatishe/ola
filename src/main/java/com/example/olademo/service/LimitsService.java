package com.example.olademo.service;

import com.example.olademo.entity.Limits;
import com.example.olademo.repository.LimitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LimitsService {
    @Autowired
    private LimitsRepository limitsRepository;

    public Limits getOneByAccountAndTypeAndCurrency(String accountUid, String typeUid, String currency){
        return limitsRepository.findByAccountUidAndTypeOfOperationUidAndCurrency(UUID.fromString(accountUid), UUID.fromString(typeUid), currency);
    }
}
