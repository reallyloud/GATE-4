package com.example.demo.service;

import com.example.demo.dto.RequestEmployee;
import com.example.demo.dto.ResponseEmployee;
import com.example.demo.dto.SalaryRequestEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.feign.SalaryManagerFeignClient;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeMapper mapper;
  private final EmployeeRepository repository;
  private final SalaryManagerFeignClient salaryManager;

  @Transactional
  public ResponseEmployee createEmployee(RequestEmployee request) {
    Employee employee = mapper.toEntity(request);
    employee = repository.save(employee);
    return mapper.toResponse(employee);
  }

  @Transactional
  public ResponseEmployee multiplyEmployeeSalary(UUID id) {
    if (repository.findById(id).isPresent()) {
      Employee employee = repository.findById(id).get();
      SalaryRequestEmployee request = mapper.toSalaryRequestEmployee(employee);
      ResponseEmployee response = salaryManager.multiplySalary(request);

      employee.setSalary(response.salary());
      employee.setName(response.name());
      employee.setId(response.id());
      repository.save(employee);

      return response;
    }
    return null;
  }

  @Transactional
  public List<ResponseEmployee> findAll() {
    List<Employee> employees = repository.findAll();
    if (employees.isEmpty()) {
      return null;
    }
    return employees.stream().map(mapper::toResponse).toList();
  }

  @Transactional
  public ResponseEmployee findById(UUID id) {
    if (repository.findById(id).isEmpty()) {
      throw new NullPointerException();
    }
    Employee employee = repository.findById(id).get();
    return mapper.toResponse(employee);
  }

  @Transactional
  public boolean deleteById(UUID id) {
    if (repository.findById(id).isEmpty()) {
      return false;
    }
    repository.deleteById(id);
    return true;
  }

  @Transactional
  public ResponseEmployee update(UUID id, RequestEmployee requestEmployee) {
    if (repository.findById(id).isEmpty()) {
      throw new NullPointerException();
    }
    Employee employee = repository.findById(id).get();
    mapper.updateEmployee(employee, requestEmployee);
    return mapper.toResponse(employee);
  }
}
