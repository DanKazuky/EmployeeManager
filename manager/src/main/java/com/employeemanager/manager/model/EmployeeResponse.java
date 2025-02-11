package com.employeemanager.manager.model;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponse {

    private String status;
    private List<Employee> data;
    private String message;

}
