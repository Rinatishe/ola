package com.example.olademo.repository;

import com.example.olademo.entity.TypeOfOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TypeOfOperationRepository extends CrudRepository<TypeOfOperation, UUID> {
}
