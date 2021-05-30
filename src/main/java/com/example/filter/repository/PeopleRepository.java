package com.example.filter.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.filter.model.People;

public interface PeopleRepository extends CrudRepository<People, Long>, JpaSpecificationExecutor<People>{
	
	List<People> findAll(Specification<People> spec);
}
