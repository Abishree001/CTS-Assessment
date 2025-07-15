package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        boolean updated = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(updatedEmployee.getId())) {
                EMPLOYEE_LIST.set(i, updatedEmployee);
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new EmployeeNotFoundException("Employee with ID " + updatedEmployee.getId() + " not found");
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void addDummyData(Employee e) {
        EMPLOYEE_LIST.add(e);
    }
}
