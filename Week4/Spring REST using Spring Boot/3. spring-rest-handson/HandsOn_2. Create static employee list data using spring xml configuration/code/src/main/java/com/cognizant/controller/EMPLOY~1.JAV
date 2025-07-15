package com.cognizant.controller;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeDao employeeDao;

    public EmployeeController() {
        this.employeeDao = new EmployeeDao();
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeDao.getAllEmployees();
    }
}
