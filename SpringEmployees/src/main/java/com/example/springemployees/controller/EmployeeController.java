package com.example.springemployees.controller;

import com.example.springemployees.entity.Employees;
import com.example.springemployees.service.EmployeesService;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class EmployeeController {
    private EmployeesService employeesService;

    @GetMapping("")
    public String getList() {
        return "/index";
    }

    public EmployeeController (EmployeesService employeesService){
        this.employeesService = employeesService;
    }
    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employees> list = employeesService.findAllEmployees();
        model.addAttribute("list", list);
        System.out.println(list);
        return "list";
    }
    @GetMapping("/employees")
    public String createProcess(Model model) {
        Employees employees = new Employees();
        model.addAttribute("employees", employees);
        return "/create";
    }
    @PostMapping("/employees")
    public String createEmployee(@Validated @ModelAttribute Employees employees, Model model) {
        employeesService.save(employees);
        model.addAttribute("success", "Create success!");
        return "redirect:/employees";
    }
}
