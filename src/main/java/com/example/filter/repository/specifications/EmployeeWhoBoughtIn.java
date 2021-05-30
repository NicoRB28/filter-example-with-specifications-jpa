package com.example.filter.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.filter.model.Employee;

public class EmployeeWhoBoughtIn implements Specification<Employee> {

	private String name;
	
	public EmployeeWhoBoughtIn(String name) {
		this.name = name;
	}
	
	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(this.name == null)
			return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
		
		
		return criteriaBuilder.like(root.join("vipBuys").join("commerce").get("name"), "%"+this.name+"%");
	}

}
