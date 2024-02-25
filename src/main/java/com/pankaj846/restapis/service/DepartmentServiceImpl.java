package com.pankaj846.restapis.service;

import com.pankaj846.restapis.entity.Department;
import com.pankaj846.restapis.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements  DepartmentService{


    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
//        DepartmentRepository departmentRepository = new DepartmentRepository();
        departmentRepository.save(department);
        return department;
    }

    // Read operation
    @Override
    public List<Department> getDepartmentList() {
        return (List<Department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public List<Department> getDepartmentByName(String departmentName) {
        List<Department> deptList = departmentRepository.findByDepartmentName(departmentName);
        System.out.println("get department by name : " +  deptList);
        return deptList;
    }

    @Override
    public List<Department> getDepartmentByNameAddress(String departmentName, String departmentAddress) {
        return departmentRepository.findByDepartmentNameAddress(departmentName, departmentAddress);
    }

    @Override
    public List<Department> getDepartmentByCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }
}