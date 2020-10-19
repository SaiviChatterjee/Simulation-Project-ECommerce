package com.saivi.orderservice.controller;

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

import com.saivi.orderservice.entity.Order;
import com.saivi.orderservice.entity.OrderItems;
import com.saivi.orderservice.entity.Product;
import com.saivi.orderservice.service.OrderService;

@RestController
@RequestMapping("/user/order-items")
public class OrderItemsController {

	@Autowired
	OrderService orderService;
	
	@GetMapping
	public List<OrderItems> getAllOrderItems() {
		return orderService.getAllOrderItems();
	}
	
	@GetMapping("/order-id/{id}")
	public OrderItems getOrderItemsById(@PathVariable("id") Long orderId) {
		return orderService.getOrderItemsById(orderId);
	}
	
	@GetMapping("/user-id/{userId}")
	public List<Order> getOrderItemsByUserId(@PathVariable("userId") Long userId) {
		return orderService.getOrderItemsByUserId(userId);
	}
	
	@PostMapping
	public OrderItems addOrderItem(@RequestBody OrderItems item) {
		return orderService.addOrUpdateOrderItems(item);
	}
	
	@PutMapping("/{id}")
	public OrderItems updateOrderItem(@RequestBody OrderItems item) {
		return orderService.addOrUpdateOrderItems(item);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrderItem(@PathVariable("id") Long orderId) {
		return orderService.deleteOrderItem(orderId);
	}
	
}
