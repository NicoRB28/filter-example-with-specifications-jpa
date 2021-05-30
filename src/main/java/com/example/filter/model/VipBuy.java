package com.example.filter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vip_buy")
public class VipBuy extends Buy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long discount;
	
	
	@ManyToOne
	private Employee employee;
	
	public VipBuy() {
		super();		
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	@JsonIgnore
	public Employee getEmploye() {
		return employee;
	}

	public void setEmploye(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
