package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.dto.RequestEmployee;
import com.example.demo.dto.ResponseEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class EmployeeServiceTest {
  @Autowired private EmployeeService service;

  @Autowired private EmployeeRepository repository;

  @Autowired private EmployeeMapper mapper;

  private Employee employee;

  @BeforeEach
  void setUp() {
    employee = new Employee();
    employee.setId(UUID.randomUUID());
    employee.setSalary(BigDecimal.valueOf(50000));
    employee.setName("Ivan");
  }

  @Test
  void shouldCreateEmployee() {
    RequestEmployee requestEmployee = new RequestEmployee();
    requestEmployee.setName("Oleg");
    requestEmployee.setSalary(BigDecimal.valueOf(45000));

    ResponseEmployee response = service.createEmployee(requestEmployee);

    assertThat(response.name()).isEqualTo("Oleg");
    assertThat(repository.findAll()).hasSize(1);
  }
}
