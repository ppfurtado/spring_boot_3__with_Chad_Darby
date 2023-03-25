package com.ppfurtado.cruddemo.controller;


import com.ppfurtado.cruddemo.entity.Employee;
import com.ppfurtado.cruddemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employees = service.findAll();
        return ResponseEntity.ok(employees);
    }
}
