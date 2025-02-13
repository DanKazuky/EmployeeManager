package com.employeemanager.manager.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.employeemanager.manager.client.EmployeeClient;
import com.employeemanager.manager.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmployeeServiceTest {

    @Mock
    private EmployeeClient employeeClient;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setName("Alice");

        when(employeeClient.getEmployeeById(1)).thenReturn(mockEmployee);

        Employee result = employeeService.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }
}