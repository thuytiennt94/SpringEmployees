package com.example.springemployees.responsitory;

import com.example.springemployees.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesResponsitory extends JpaRepository<Employees, Long> {

}
