package com.ppfurtado.cruddemo.repository;


import com.ppfurtado.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "empregados")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
