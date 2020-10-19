package com.saivi.userservice.Entity;

import java.math.BigDecimal;

public class Product {

	
	private Long id;
	private String productName;
	private BigDecimal price;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String productName, BigDecimal price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
}
