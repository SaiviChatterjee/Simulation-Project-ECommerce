package com.saivi.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saivi.orderservice.ProductCatalogServiceProxy;
import com.saivi.orderservice.entity.Order;
import com.saivi.orderservice.entity.OrderItems;
import com.saivi.orderservice.entity.Product;
import com.saivi.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	ProductCatalogServiceProxy proxy;
	
	public List<OrderItems> getAllOrderItems() {
		return repo.findAll();
	}
	
	public OrderItems getOrderItemsById(Long orderId) {
		return repo.findById(orderId).orElse(new OrderItems());
	}
	
	public List<Order> getOrderItemsByUserId(Long userId) {
		List<OrderItems> items = repo.findAllByUserId(userId);
		List<Order> productList = new ArrayList<>();
		
		for(OrderItems item:items) {
			productList.add(new Order(proxy.viewProductById(item.getProductId()), item.getQuantity()));
		}
		return productList;
	}
	
	public OrderItems addOrUpdateOrderItems(OrderItems items) {
		return repo.save(items);
	}
	
	public String deleteOrderItem(Long orderId) {
		repo.deleteById(orderId);
		return "Order deleted";
	}
	
	
}
