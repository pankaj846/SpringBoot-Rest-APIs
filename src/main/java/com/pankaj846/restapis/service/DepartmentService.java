package com.pankaj846.restapis.service;

import com.pankaj846.restapis.entity.Department;

import java.util.List;

public interface DepartmentService {

    // Create
    Department saveDepartment(Department department);

    // Read
    List<Department> getDepartmentList();

    // Update
    Department updateDepartment(Department department, Long departmentId);

    // Delete
    void deleteDepartmentById(Long departmId);

    // find by name
    List<Department> getDepartmentByName(String departmentName);

    List<Department> getDepartmentByNameAddress(String departmentName, String departmentAddress);

    List<Department> getDepartmentByCode(String departmentCode);
}
