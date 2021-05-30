package com.example.filter.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.filter.model.Customer;

public class CustomerWhoBoughtIn implements Specification<Customer> {
	
	private String name;
	
	public CustomerWhoBoughtIn(String name) {
		this.name = name;
	}

	@Override
	public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(this.name == null)
			return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
		
		return criteriaBuilder.like(root.join("normalBuys").join("commerce").get("name"), "%"+this.name+"%");
	}
	
	
}
