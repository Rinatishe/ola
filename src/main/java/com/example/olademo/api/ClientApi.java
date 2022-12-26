package com.example.olademo.api;

import com.example.olademo.dto.ClientDto;
import com.example.olademo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientApi {
    @Autowired
    private ClientService clientService;

//    @GetMapping("/hello")
//    public String returnHelloWorld(){
//        return "helloWorld";
//    }
//
//    @GetMapping("/hello2")
//    public String returnHelloWorld2(){
//        return "helloWorld2";
//    }

    @GetMapping("/clients")
    public List<ClientDto> getAllClients(){
        return clientService.getAllClient();
    }

    @PostMapping("/create")
    public UUID create(@RequestBody ClientDto dto){
        return clientService.create(dto);
    }

    @PostMapping("/update")
    public UUID update(@RequestBody ClientDto dto){
        return clientService.save(dto);
    }
}
