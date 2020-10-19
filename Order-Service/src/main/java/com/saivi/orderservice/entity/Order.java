package com.saivi.orderservice.entity;

public class Order {

	private Product product;
	private int quantity;
	
	public Order() {
		super();
	}

	public Order(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [product=" + product + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
