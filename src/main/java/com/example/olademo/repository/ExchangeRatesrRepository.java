package com.example.olademo.repository;

import com.example.olademo.entity.ExchangeRates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeRatesrRepository extends CrudRepository<ExchangeRates, UUID> {
}
