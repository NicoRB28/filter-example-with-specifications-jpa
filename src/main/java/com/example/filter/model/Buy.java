package com.example.filter.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="buy")
public class Buy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private int cant;
	
	@ManyToMany
	@JoinTable(
			name="buy_product",
			joinColumns = @JoinColumn(name="buy_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "id")
			)
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="commerce_id",referencedColumnName = "id")
	private Commerce commerce;
	
	public Buy() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Commerce getCommerce() {
		return commerce;
	}


	public void setCommerce(Commerce commerce) {
		this.commerce = commerce;
	}
	
	
}
