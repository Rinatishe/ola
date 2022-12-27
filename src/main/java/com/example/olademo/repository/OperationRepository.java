package com.example.olademo.repository;

import com.example.olademo.entity.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OperationRepository extends CrudRepository<Operation, UUID> {

    List<Operation> findAllByAccountUidAndLimitExceedTrue(UUID accountUid);
}
