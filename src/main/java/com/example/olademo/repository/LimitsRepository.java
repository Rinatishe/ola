package com.example.olademo.repository;

import com.example.olademo.entity.Limits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LimitsRepository extends CrudRepository<Limits, UUID> {
}
