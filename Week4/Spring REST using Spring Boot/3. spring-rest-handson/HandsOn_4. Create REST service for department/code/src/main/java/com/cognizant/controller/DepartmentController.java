package com.cognizant.controller;

import com.cognizant.model.Department;
import com.cognizant.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private DepartmentService departmentService = new DepartmentService();

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("Start getAllDepartments");
        return departmentService.getAllDepartments();
    }
}
