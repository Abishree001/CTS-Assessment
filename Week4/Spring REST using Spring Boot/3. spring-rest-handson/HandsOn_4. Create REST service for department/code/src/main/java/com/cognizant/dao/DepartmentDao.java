package com.cognizant.dao;

import com.cognizant.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentDao {
    private static List<Department> DEPARTMENT_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
