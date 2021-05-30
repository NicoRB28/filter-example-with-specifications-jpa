package com.example.filter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.filter.model.Customer;
import com.example.filter.repository.CustomerRepository;
import com.example.filter.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllFiltered(Specification<Customer> spec) {
		return this.customerRepository.findAll(spec);
	}
	
	
}
