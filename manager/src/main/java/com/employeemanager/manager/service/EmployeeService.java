package com.employeemanager.manager.service;

import com.employeemanager.manager.client.EmployeeClient;
import com.employeemanager.manager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeClient employeeClient;

    public EmployeeService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public List<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    public List<Employee> getEmployeeById(int id) {
        return employeeClient.getEmployeeById(id);
    }
}
