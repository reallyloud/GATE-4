package com.example.demo.dto;

import jakarta.persistence.Version;

import java.math.BigDecimal;
import java.util.UUID;

public record ResponseEmployee(UUID id, String name, BigDecimal salary) { };
