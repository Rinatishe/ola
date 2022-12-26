package com.example.olademo.api;

import com.example.olademo.dto.TypeOfOperationDto;
import com.example.olademo.service.TypeOfOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TypeOfOperation")
public class TypeOfOperationApi {
        @Autowired
        private TypeOfOperationService typeOfOperationService;

        @GetMapping("/TypeOfOperations")
        public List<TypeOfOperationDto> getAllTypeOfOperation(){
                return typeOfOperationService.getAllTypeOfOperation();
        }
}
