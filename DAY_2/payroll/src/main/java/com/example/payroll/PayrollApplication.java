package com.example.payroll;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Department;
import com.example.payroll.model.Employee;
import com.example.payroll.service.DepartmentService;
import com.example.payroll.service.EmployeeService;
import com.example.payroll.service.SkillService;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.payroll.*")
public class PayrollApplication {
	 @Autowired
	    private EmployeeService employeeService;
	
	public static void main(String[] args) {
		//SpringApplication.run(PayrollApplication.class, args);
		//ConfigurableApplicationContext context = SpringApplication.run(PayrollApplication.class, args);

		 //context.getApplicationName().
		//SpringApplication app = new SpringApplication(PayrollApplication.class);
		//app.run(args);
		
		
		 ApplicationContext applicationContext = SpringApplication.run(PayrollApplication.class, args);
	       EmployeeService service = applicationContext.getBean(EmployeeService.class);
	    //  DepartmentService service1 = applicationContext.getBean(DepartmentService.class);
		 SkillService service2 = applicationContext.getBean(SkillService.class);
	      /* Employee emp=new Employee();
	    	emp.setId(3);
	    	emp.setName("Raman");
	    	emp.setPermanent(true);
	    	emp.setSalary(90000.0);
	    Department d=new Department();
	    	d.setId(101);
	    	d.setName("Admin");
	    	/*service1.save(d);*/
	  /* emp.setDateOfBirth(new Date());
	    	emp.setDepartment(d);
	        service.save(emp);*/
	     /* Department d=service1.get(101);
	      System.out.println(d.getName());*/
	    //  Set<Employee> empSet=new LinkedHashSet<>();
	   Employee e=service.get(2);
	    
	   System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
	}
	
	/* public void run(String...args) throws Exception{
		 System.out.println("helllooooooooooooooo");
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
*/
}
