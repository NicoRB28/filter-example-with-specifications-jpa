package com.example.filter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee extends People {
		

	private String number;
	
	private String sector;
	
	@OneToMany(mappedBy = "employee")
	private List<VipBuy> vipBuys;
	
	public Employee() {
		super();

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public List<VipBuy> getProducts() {
		return vipBuys;
	}

	public void setProducts(List<VipBuy> products) {
		this.vipBuys = products;
	}
	
	
	
}
