package com.example.olademo.repository;

import com.example.olademo.entity.Limits;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LimitsRepository extends CrudRepository<Limits, UUID> {

    @Query(value = "select *from limits where account_uid = ? and operation_category_uid = ? and currency = ?", nativeQuery = true)
    Limits findByAccountUidAndTypeOfOperationUidAndCurrency(UUID accountUid, UUID typeUid, String currency);
}
