package com.example.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Employee;
import com.example.payroll.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository emp;
	
	@Transactional
	public Employee get(int id) {

	//LOGGER.info("Start");

	return emp.findById(id).get();
}
	@Transactional
    public void save(Employee employee) {

	//LOGGER.info("Start");

	emp.save(employee);

	
}}