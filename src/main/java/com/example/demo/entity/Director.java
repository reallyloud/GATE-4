package com.example.demo.entity;

import factory.People;
import lombok.Data;

import java.util.UUID;

@Data
public class Director implements People {
    private UUID id;
    private String name;
}
