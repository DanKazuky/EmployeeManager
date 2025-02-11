package com.employeemanager.manager.controller;

import com.employeemanager.manager.model.Employee;
import com.employeemanager.manager.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}
