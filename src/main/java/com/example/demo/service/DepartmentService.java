package com.example.demo.service;

import com.example.demo.Entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Optional<Department> getDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Department department, Long id);

    public Department getByDepartmentName(String deptName);
}
