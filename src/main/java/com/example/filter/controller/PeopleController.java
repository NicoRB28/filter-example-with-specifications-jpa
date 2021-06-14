package com.example.filter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filter.model.Customer;
import com.example.filter.model.Employee;
import com.example.filter.model.People;
import com.example.filter.repository.specifications.CustomerWhoBoughtIn;
import com.example.filter.repository.specifications.EmployeeWhoBoughtIn;
import com.example.filter.repository.specifications.SpecificationFactory;
import com.example.filter.service.CustomerService;
import com.example.filter.service.EmployeeService;
import com.example.filter.service.PeopleService;


@RestController
@RequestMapping("people")
@CrossOrigin(origins = "*")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("filterPeople/{commerceName}")
	public List<? extends People> getPeopleFiltered(@PathVariable String commerceName) {
		Specification<Customer> customerWhoBoughtIn = SpecificationFactory.like(Arrays.asList("normalBuys","commerce"),commerceName,"name");
		Specification<Employee> employeeWhoBoughtIn = SpecificationFactory.like(Arrays.asList("vipBuys","commerce"),commerceName,"name");
		//List<Customer> responseCustomers = this.customerService.getAllFiltered(new CustomerWhoBoughtIn(commerceName));
		//List<Employee> responseEmployees = this.employeeService.getAllFiltered();
		List<Customer> responseCustomers = this.customerService.getAllFiltered(customerWhoBoughtIn);
		List<Employee> responseEmployee = this.employeeService.getAllFiltered(employeeWhoBoughtIn);
		
		List<People> finalResponse = new ArrayList<>();
		
		finalResponse.addAll(responseCustomers);
		finalResponse.addAll(responseEmployee);

		return finalResponse;
	}
	
	@GetMapping("/")
	public List<People> getAll(){
		return this.peopleService.getAll();
	}
	
	
}
