package com.saivi.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saivi.userservice.service.UserService;
import com.saivi.userservice.OrderServiceProxy;
import com.saivi.userservice.Entity.Order;
import com.saivi.userservice.Entity.Product;
import com.saivi.userservice.Entity.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	OrderServiceProxy proxy;
	
	@GetMapping("/admin")
	public List<User> viewAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/admin/{id}")
	public User viewUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.addOrUpdate(user);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user) {
		return userService.addOrUpdate(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.delete(id);
	}
	
	@GetMapping("admin-user/user-orders/{id}")
	public List<Order> viewOrderById(@PathVariable("id") Long id) {
		return proxy.getOrderItemsByUserId(id);
	}
}
