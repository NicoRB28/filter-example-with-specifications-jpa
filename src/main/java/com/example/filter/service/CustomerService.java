package com.example.filter.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.filter.model.Customer;

public interface CustomerService {
	public List<Customer> getAllFiltered(Specification<Customer> spec);
}
