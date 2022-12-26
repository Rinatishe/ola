package com.example.olademo.api;

import com.example.olademo.dto.OperationDto;
import com.example.olademo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/operation")
public class OperationApi {
    @Autowired
    private OperationService operationService;

    @PostMapping("/create")
    public UUID create(@RequestBody OperationDto dto){
        return operationService.create(dto);
    }
}
