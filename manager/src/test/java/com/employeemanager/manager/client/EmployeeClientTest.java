package com.employeemanager.manager.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.employeemanager.manager.model.Employee;
import com.employeemanager.manager.model.EmployeeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class EmployeeClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeClient employeeClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        int id = 1;
        HttpEntity<EmployeeResponse> entity;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie","humans_21909=1");
        entity = new HttpEntity<>(headers);
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;

        Employee mockEmployee = new Employee();
        mockEmployee.setId(id);
        mockEmployee.setName("John Doe");
        mockEmployee.setSalary("50000");
        mockEmployee.setAge("30");

        EmployeeResponse mockResponse = new EmployeeResponse();
        mockResponse.setDatas(mockEmployee);

        when(restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, EmployeeResponse.class))
                .thenReturn(ResponseEntity.ok(mockResponse));

        Employee result = employeeClient.getEmployeeById(id);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("50000", result.getSalary());
    }
}