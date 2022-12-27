package com.example.olademo.repository;

import com.example.olademo.entity.OperationCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationCategoryRepository extends CrudRepository<OperationCategory, UUID> {
}
