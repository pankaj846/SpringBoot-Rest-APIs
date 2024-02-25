package com.pankaj846.restapis.controller;

import com.pankaj846.restapis.entity.Department;
import com.pankaj846.restapis.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    // @RequestBody => department JSON object is deserialized/converted into a Java employee object
    @PostMapping("/departments")
    public Department saveDepartments(@RequestBody Department department){
        System.out.println(department);
//        DepartmentService departmentService = new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/code/{code}")
    public List<Department> getAllDepartmentsByCode(@PathVariable("code") String departmentCode){
        return departmentService.getDepartmentByCode(departmentCode);
    }


    // path variable should be match with variable under {} and this variable bind to departmentName
    @GetMapping("/departments/name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

    // add two path variables
    @GetMapping("/departments/name/{name}/address/{address}")
    public List<Department> getDepartmentsByName(@PathVariable("name") String departmentName, @PathVariable("address") String departmentAddress){
        return departmentService.getDepartmentByNameAddress(departmentName, departmentAddress);
    }
}
