package com.example.demo.service;

import com.example.demo.dto.RequestEmployee;
import com.example.demo.dto.ResponseEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper mapper;
    private final EmployeeRepository repository;



    @Transactional
    public ResponseEmployee createEmployee(RequestEmployee request) {
        Employee employee = mapper.toEntity(request);
        employee = repository.save(employee);
        return mapper.toResponse(employee);

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
    public ResponseEmployee update(UUID id,RequestEmployee requestEmployee){
        if (repository.findById(id).isEmpty()) {
            throw new NullPointerException();
        }
        Employee employee = repository.findById(id).get();
        mapper.updateEmployee(employee,requestEmployee);
        return mapper.toResponse(employee);
    }

}
