package com.saivi;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.saivi.userservice.Entity.Product;
import com.saivi.userservice.Entity.User;

class UserTest {

	User user = new User();
	
	@Test
	public void userConstructorTest() {
		User user  = new User(1L, "saivi", "abc", "ADMIN", true);
		assertEquals(1L, user.getId());
	}
	
	@Test
	public void getIdTest() {
		user.setId(1L);
		assertEquals(1L, user.getId());
	}
	
	@Test
	public void getUserNameTest() {
		user.setUserName("saivi");;
		assertEquals("saivi", user.getUserName());
	}
	
	@Test
	public void getPasswordTest() {
		user.setPassword("abc");
		assertEquals("abc", user.getPassword());
	}
	
	@Test
	public void getRoleTest() {
		user.setRole("ADMIN");;
		assertEquals("ADMIN", user.getRole());
	}
	
	@Test
	public void getActiveTest() {
		user.setActive(true);
		assertEquals(true, user.isActive());
	}
}
