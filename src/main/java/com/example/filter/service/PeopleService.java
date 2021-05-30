package com.example.filter.service;

import java.util.List;

import com.example.filter.model.People;

public interface PeopleService {
	
	public List<People> getPeopleWhoBoughtInCommerce(String commerceName);
	
	public List<People> getAll();
}
