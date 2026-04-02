package com.example.salarymanager.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ResponseEmployeeDto(UUID id, String name, BigDecimal salary){}
