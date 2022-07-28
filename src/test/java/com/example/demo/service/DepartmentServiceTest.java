package com.example.demo.service;

import com.example.demo.Entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Software-Dev")
                .departmentId(1L)
                .departmentAddress("Chennai")
                .departmentCode("IT-70").build();
        Mockito.when(departmentRepository.findByDepartmentName("Software-Dev"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "Software-Dev";
        Department found = departmentService.getByDepartmentName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}