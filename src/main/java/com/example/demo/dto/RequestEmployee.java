package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class RequestEmployee {
  @NotBlank private String name;
  private BigDecimal salary;
}
