package com.example.filter.model;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="normal_buy")
public class NormalBuy extends Buy{


	private Long increse;
	
	@JsonIgnore	
	@ManyToOne
	private Customer customer;

	public NormalBuy() {
		super();
	}

	public Long getIncrese() {
		return increse;
	}

	public void setIncrese(Long increse) {
		this.increse = increse;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
