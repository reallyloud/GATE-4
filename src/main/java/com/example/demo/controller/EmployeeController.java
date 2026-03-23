package com.example.demo.controller;

import com.example.demo.dto.RequestEmployee;
import com.example.demo.dto.ResponseEmployee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService service;

  @PostMapping()
  public ResponseEntity<ResponseEmployee> createEmployee(
      @Valid @RequestBody RequestEmployee requestEmployee) {
    ResponseEmployee response = service.createEmployee(requestEmployee);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ResponseEmployee> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseEmployee> getEmployeeById(@PathVariable UUID id) {
    ResponseEmployee response = service.findById(id);
    return ResponseEntity.status(200).body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseEmployee> deleteEmployee(@PathVariable UUID id) {
    boolean deleted = service.deleteById(id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseEmployee> updateEmployee(
      @PathVariable UUID id, @RequestBody RequestEmployee request) {
    ResponseEmployee response = service.update(id, request);
    return ResponseEntity.ok(response);
  }
}
