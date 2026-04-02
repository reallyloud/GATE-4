package com.example.salarymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestEmployeeDto {
    private UUID id;
    private String name;
    private BigDecimal salary;
}
