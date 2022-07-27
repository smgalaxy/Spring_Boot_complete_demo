package com.example.demo.controller;

import com.example.demo.Entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //private final Logger LOGGER = (Logger) LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department)
    {
        //LOGGER.info("Inside saveDepartment method in DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getDepartments()
    {
        return departmentService.getDepartments();
    }
    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id)
    {
        departmentService.deleteDepartmentById(id);
        return "Successfully deleted the department";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long id)
    {
        return departmentService.updateDepartment(department,id);
    }
    @GetMapping("/departments/name/{name}")
    public Department getByDepartmentName(@PathVariable("name") String deptName)
    {
        return departmentService.getByDepartmentName(deptName);
    }
}
