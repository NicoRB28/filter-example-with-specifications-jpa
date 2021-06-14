package com.example.filter.repository.specifications;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationFactory<T> {
	@SuppressWarnings("rawtypes")
	public  static <T> Specification<T> equals(List<String> joinTo, String valueToCompare, String attribute){
		 return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb)-> {
			if(!joinTo.isEmpty()) {
				Join initJoin = getJoin(joinTo,root);
				return cb.equal(initJoin.get(attribute), valueToCompare);
			}
			return cb.equal(root.get(attribute), valueToCompare );
		 };
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> Specification<T> like(List<String> joinTo, String valueToCompare, String atribute){
		return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb)-> {
			if(!joinTo.isEmpty()) {
				Join initJoin = getJoin(joinTo,root);
				return cb.like(initJoin.get(atribute), "%"+valueToCompare+"%");
			}
			return cb.equal(root.get(atribute), "%"+ valueToCompare +"%" );
		 };
	}
	
	@SuppressWarnings("rawtypes")
	public static <T,E> Specification<T> in(List<String> joinTo, List<E> elements, String atribute){
		return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb)-> {
			if(!joinTo.isEmpty()) {
				Join initJoin = getJoin(joinTo, root);
				return initJoin.get(atribute).in(elements);
			}
			return root.get(atribute).in(elements);
		 };
	}
	
	@SuppressWarnings("rawtypes")
	private static <T> Join getJoin(List<String> joinTo, Root<T> root) {
		Join initJoin = root.join(joinTo.get(0));
		for (int i = 1; i < joinTo.size(); i++) {
			initJoin = initJoin.join(joinTo.get(i));
		}
		return initJoin;
	}
}
