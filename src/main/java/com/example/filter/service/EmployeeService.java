package com.example.filter.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.filter.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllFiltered(Specification<Employee> spec);
}
