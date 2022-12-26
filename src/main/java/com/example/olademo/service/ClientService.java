package com.example.olademo.service;

import com.example.olademo.dto.ClientDto;
import com.example.olademo.entity.Client;
import com.example.olademo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationService operationService;

//    private final ClientRepository clientRepository;

//    public ClientService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }


    public List<ClientDto> getAllClient(){
        List<Client> clientList = (List<Client>) clientRepository.findAll();


        List<ClientDto> clientDtos = new ArrayList<>();
        //List<ClientDto> clientDtos = clientMapper.map();
        for (Client entry : clientList) {
            ClientDto dto = new ClientDto();
            dto.uid = entry.getUid().toString();
            dto.firstName = entry.getFirstName();
            dto.lastName = entry.getLastName();
            dto.accountNumber = entry.getAccountNumber();
            dto.email = entry.getEmail();
            dto.phone = entry.getPhone();
            clientDtos.add(dto);
        }
        return clientDtos;
    }

    public UUID create(ClientDto dto){
        if(dto == null) return null;
        Client client = new Client();
        client.setFirstName(dto.firstName);
        client.setLastName(dto.lastName);
        client.setAccountNumber(dto.accountNumber);
        client.setEmail(dto.email);
        client.setPhone(dto.phone);

        client = clientRepository.save(client);
        return client.getUid();
    }

    public UUID save(ClientDto dto){
        if(dto == null) return null;
        Client client = clientRepository.findById(UUID.fromString(dto.uid)).get();
        if(client == null) return null;

        client.setFirstName(dto.firstName);
        client.setLastName(dto.lastName);
        client.setAccountNumber(dto.accountNumber);
        client.setEmail(dto.email);
        client.setPhone(dto.phone);

        client = clientRepository.save(client);
        return client.getUid();
    }
}
