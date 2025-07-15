package com.cognizant.dao;

import com.cognizant.model.Employee;

import java.util.List;

public class EmployeeDao {
    private List<Employee> employeeList;

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
