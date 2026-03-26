package com.example.demo.entity;

import factory.People;
import java.util.UUID;
import lombok.Data;

@Data
public class Director implements People {
  private UUID id;
  private String name;
}
