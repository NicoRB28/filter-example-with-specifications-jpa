package com.example.filter.model;


import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends People{
	
	@OneToMany(mappedBy = "customer")
	private List<NormalBuy> normalBuys;
	
	public Customer() {
		super();
	}

	public List<NormalBuy> getProducts() {
		return normalBuys;
	}

	public void setProducts(List<NormalBuy> products) {
		this.normalBuys = products;
	}
	
	
}
