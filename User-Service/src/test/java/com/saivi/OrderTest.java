package com.saivi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.saivi.userservice.UserServiceApplication;
import com.saivi.userservice.Entity.Order;
import com.saivi.userservice.Entity.Product;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = UserServiceApplication.class)
@RunWith(SpringRunner.class)
class OrderTest {

	
	Order order = new Order();
	
	@Test
	public void orderConstructorTest() {
		BigDecimal price = new BigDecimal(25000);
		Order order = new Order(new Product(1L, "TV", price), 2);
		assertEquals(2, order.getQuantity());
	}
	
	@Test
	public void getProductTest() {
		BigDecimal price = new BigDecimal(25000);
		Product product = new Product(1L, "TV", price);
		order.setProduct(product);
		assertEquals(product, order.getProduct());
	}
	
	@Test
	public void getQuantityTest() {
		order.setQuantity(2);
		assertEquals(2, order.getQuantity());
	}

}
