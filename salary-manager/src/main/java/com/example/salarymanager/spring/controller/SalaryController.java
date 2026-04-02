package com.example.salarymanager.spring.controller;

import com.example.salarymanager.dto.RequestEmployeeDto;
import com.example.salarymanager.dto.ResponseEmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class SalaryController {
    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEmployeeDto multiplySalary(@RequestBody RequestEmployeeDto request) {
        return new ResponseEmployeeDto(
                request.getId(),
                request.getName(),
                request.getSalary().multiply(BigDecimal.valueOf(2))
                );
    }
}
