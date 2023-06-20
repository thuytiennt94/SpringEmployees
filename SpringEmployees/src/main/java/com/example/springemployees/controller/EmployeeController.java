package com.example.springemployees.controller;

import com.example.springemployees.entity.Employees;
import com.example.springemployees.service.EmployeesService;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class EmployeeController {
    private EmployeesService employeesService;
    public EmployeeController (EmployeesService employeesService){
        this.employeesService = employeesService;
    }
    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employees> list = employeesService.findAllEmployees();
        model.addAttribute("list", list);
        return "list";
    }

    @PostMapping("/employees")
    public String createEmployee(Employees employees) {
        employeesService.Save(employees);
        return "saveEmployees";
    }
}
