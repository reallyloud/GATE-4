package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestEmployee {
    @NotBlank
    private String name;
    private BigDecimal salary;
}
