package com.example.olademo.api;

import com.example.olademo.dto.LimitDto;
import com.example.olademo.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/limit")
public class LimitsApi {
    @Autowired
    private LimitsService limitsService;

    @PostMapping("/save")
    public UUID save(@RequestBody LimitDto dto){
        return limitsService.save(dto);
    }
}
