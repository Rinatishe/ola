package com.example.olademo.repository;

import com.example.olademo.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {

//    @Query(value = "select email from client group by email", nativeQuery = true)
//    List<String> custom();
//
//    @Query(value = "select *from client where email = ?", nativeQuery = true)
//    List<Client> custom2(String email);
//
//    List<Client> findByEmail(String email);
//
//    List<Client> findAll();
}
