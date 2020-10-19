package com.saivi.userservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saivi.userservice.Entity.Order;



@FeignClient(name = "order-service")
@RibbonClient(name = "order-service")
public interface OrderServiceProxy {

	@GetMapping("user/order-items/user-id/{userId}")
	public List<Order> getOrderItemsByUserId(@PathVariable("userId") Long userId);
	
}
