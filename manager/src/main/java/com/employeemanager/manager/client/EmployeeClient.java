package com.employeemanager.manager.client;

import com.employeemanager.manager.model.Employee;
import com.employeemanager.manager.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeClient {

    private final RestTemplate restTemplate;
    private HttpEntity<EmployeeResponse> entity;

    @Value("${api.base-url}")
    private String baseUrl;

    public EmployeeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie","humans_21909=1");
        entity = new HttpEntity<>(headers);
    }

    public List<Employee> getAllEmployees() {
        String url = baseUrl + "/employees";
        EmployeeResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, EmployeeResponse.class).getBody();
        return response.getData();
    }

    public Employee getEmployeeById(int id) {
        String url = baseUrl + "/employee/" + id;
        ResponseEntity<EmployeeResponse> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, EmployeeResponse.class);

        return response.getBody().getDatas();
    }

}
