package com.saivi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.saivi.userservice.Entity.Product;

class ProductTest {

	Product product = new Product();
	
	@Test
	public void productConstructorTest() {
		BigDecimal price = new BigDecimal(25000);
		Product product = new Product(1L, "TV", price);
		assertEquals(1L, product.getId());
	}
	
	@Test
	public void getIdTest() {
		product.setId(1L);
		assertEquals(1L, product.getId());
	}
	
	@Test
	public void getProductNameTest() {
		product.setProductName("TV");
		assertEquals("TV", product.getProductName());
	}
	
	@Test
	public void getPriceTest() {
		BigDecimal price = new BigDecimal(25000);
		product.setPrice(price);
		assertEquals(price, product.getPrice());
	}
}
