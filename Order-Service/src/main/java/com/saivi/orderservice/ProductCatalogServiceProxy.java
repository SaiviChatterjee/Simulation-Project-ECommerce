package com.saivi.orderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saivi.orderservice.entity.Product;

@FeignClient(name = "product-catalog-service")
@RibbonClient(name = "product-catalog-service")
public interface ProductCatalogServiceProxy {

	@GetMapping("/admin-user/products/{id}")
	public Product viewProductById(@PathVariable("id") Long id);
}
