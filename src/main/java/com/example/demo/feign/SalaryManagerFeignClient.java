package com.example.demo.feign;

import com.example.demo.dto.ResponseEmployee;
import com.example.demo.dto.SalaryRequestEmployee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "salary-manager")
public interface SalaryManagerFeignClient {
  @PostMapping("/api/multiply")
  ResponseEmployee multiplySalary(@RequestBody SalaryRequestEmployee employee);
}
