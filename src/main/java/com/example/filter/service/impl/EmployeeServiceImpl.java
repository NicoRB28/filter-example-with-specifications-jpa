package com.example.filter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.filter.model.Employee;
import com.example.filter.repository.EmployeeRepository;
import com.example.filter.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllFiltered(Specification<Employee> spec) {
		return this.employeeRepository.findAll(spec);
	}
	
}
