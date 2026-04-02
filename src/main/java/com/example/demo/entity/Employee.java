package com.example.demo.entity;

import factory.People;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements People {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private BigDecimal salary;

  @Version
  @Setter(AccessLevel.NONE)
  private Long version;
}
