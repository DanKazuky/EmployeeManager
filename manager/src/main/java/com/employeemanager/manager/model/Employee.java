package com.employeemanager.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Employee {
    private int id;

    @JsonProperty("employee_name")
    private String name;

    @JsonProperty("employee_salary")
    private String salary;

    @JsonProperty("employee_age")
    private String age;

}
