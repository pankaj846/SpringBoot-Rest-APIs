package com.pankaj846.restapis.repository;

import com.pankaj846.restapis.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


// Need to pass in jparepository => entity name and type of primary key
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    //https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
    // JPA Query creation => if want some custom query
    // syntax => findBy + FieldName
    public List<Department> findByDepartmentCode(String departmentCode);

    // Add custom queries
    @Query(value="Select * from department where department_name = ?1", nativeQuery = true)
    public List<Department> findByDepartmentName(String departmentName);

    @Query(value="Select * from department where department_name = ?1 and department_address = ?2", nativeQuery = true)
    public List<Department> findByDepartmentNameAddress(String departmentName, String departmentAddress);
}
