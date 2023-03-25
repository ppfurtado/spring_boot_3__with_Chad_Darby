package com.ppfurtado.cruddemo.service;


import com.ppfurtado.cruddemo.entity.Employee;
import com.ppfurtado.cruddemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }
}
