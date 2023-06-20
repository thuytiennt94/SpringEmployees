package com.example.springemployees.service;

import com.example.springemployees.entity.Employees;
import com.example.springemployees.responsitory.EmployeesResponsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    private EmployeesResponsitory repository;
    public EmployeesService(EmployeesResponsitory repository) {
        this.repository = repository;
    }

    public List<Employees> findAllEmployees() {
        return (List<Employees>) findAllEmployees();
    }

    public void save(Employees employees){

        repository.save(employees);
    }
}
