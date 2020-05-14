package com.example.payroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.payroll.model.Department;

public interface DepartmentRepository extends CrudRepository<Department,Integer>{

}
