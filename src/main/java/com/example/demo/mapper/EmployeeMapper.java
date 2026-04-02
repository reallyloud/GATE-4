package com.example.demo.mapper;

import com.example.demo.dto.RequestEmployee;
import com.example.demo.dto.ResponseEmployee;
import com.example.demo.dto.SalaryRequestEmployee;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface EmployeeMapper {

  @Mapping(target = "id", ignore = true)
  Employee toEntity(RequestEmployee requestEmployee);

  Employee toEntity(ResponseEmployee responseEmployee);

  SalaryRequestEmployee toSalaryRequestEmployee(Employee employee);

  ResponseEmployee toResponse(Employee employee);

  @Mapping(target = "id", ignore = true)
  void updateEmployee(@MappingTarget Employee employee, RequestEmployee requestEmployee);
}
