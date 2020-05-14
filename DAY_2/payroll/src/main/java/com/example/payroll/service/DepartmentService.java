package com.example.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Department;
import com.example.payroll.model.Employee;
import com.example.payroll.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository dept;
	
	@Transactional
	public Department get(int id) {

	//LOGGER.info("Start");

	return dept.findById(id).get();
}
	@Transactional
    public void save(Department department) {

	//LOGGER.info("Start");

	dept.save(department);



	
}}

