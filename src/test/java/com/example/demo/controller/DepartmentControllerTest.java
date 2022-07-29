package com.example.demo.controller;

import com.example.demo.Entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentCode("IT-14")
                .departmentAddress("Chennai")
                .departmentName("Software-Dev")
                .departmentId(1L).build();
        System.out.println("department"+department);
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentCode("IT-14")
                .departmentAddress("Chennai")
                .departmentName("Software-Dev")
                .departmentId(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"Software-Dev\",\n" +
                        "    \"departmentCode\":\"IT-14\",\n" +
                        "    \"departmentAddress\":\"Chennai\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

//    @Test
//    void getDepartmentById() throws Exception {
//        Mockito.when(departmentService.getDepartmentById(1L))
//                .thenReturn(Optional.ofNullable(department));
//
//        mockMvc.perform(post("/departments/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departmentName")
//                        .value(department.getDepartmentName()));
//
//    }
}