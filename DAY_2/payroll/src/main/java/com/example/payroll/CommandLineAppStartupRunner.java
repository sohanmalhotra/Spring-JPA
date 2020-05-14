package com.example.payroll;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.payroll.model.Department;
import com.example.payroll.model.Employee;
import com.example.payroll.service.EmployeeService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String...args) throws Exception {
    	System.out.println("helllooooooooooooooooooooooooo/ngekllllllllllll");
    	Employee emp=new Employee();
		emp.setId(1);
		emp.setName("AMAN");
		emp.setPermanent(true);
		emp.setSalary(50000.0);
		Department d=new Department();
		d.setId(101);
		d.setName("Admin");
		emp.setDateOfBirth(new Date());
		emp.setDepartment(d);
		employeeService.save(emp);
		

    }
}