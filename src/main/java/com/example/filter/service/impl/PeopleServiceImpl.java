package com.example.filter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filter.model.People;
import com.example.filter.repository.PeopleRepository;

import com.example.filter.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	public List<People> getPeopleWhoBoughtInCommerce(String commerceName) {
		return null;
	}

	@Override
	public List<People> getAll() {
		return (List<People>) this.peopleRepository.findAll();
	}
	
	
	
}
