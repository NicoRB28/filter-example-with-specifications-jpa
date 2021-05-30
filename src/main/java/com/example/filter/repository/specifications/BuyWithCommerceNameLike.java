package com.example.filter.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.filter.model.Buy;

public class BuyWithCommerceNameLike implements Specification<Buy> {
	
	private String commerceName;
	
	public BuyWithCommerceNameLike(String name) {
		this.commerceName = name;
	}
	
	@Override
	public Predicate toPredicate(Root<Buy> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(this.commerceName == null)
			return cb.isTrue(cb.literal(true));
		
		return cb.like(root.join("commerce").get("name"), "%"+this.commerceName+"%");
	}
	
}
