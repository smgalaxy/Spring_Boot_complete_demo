package com.example.demo.service;

import com.example.demo.Entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        //return Optional.ofNullable(departmentRepository.findById(id).orElse(new Department()));
        return department;
    }
    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Department deptDB = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            deptDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            deptDB.setDepartmentAddress(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(deptDB);
    }

    @Override
    public Department getByDepartmentName(String deptName) {
        return departmentRepository.findByDepartmentName(deptName);
    }

}
