package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record SalaryRequestEmployee(UUID id, String name, BigDecimal salary) {}
