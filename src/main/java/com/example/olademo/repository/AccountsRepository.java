package com.example.olademo.repository;

import com.example.olademo.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, UUID> {
}
