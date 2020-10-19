package com.saivi.productcatalogservice.controller;

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

import com.saivi.productcatalogservice.service.ProductService;
import com.saivi.productcatalogservice.entity.Product;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/admin-user/products")
	public List<Product> viewAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/admin-user/products/{id}")
	public Product viewProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/admin")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addorUpdateProduct(product);
	}
	
	@PutMapping("/admin/{id}")
	public Product updateProduct(@RequestBody Product product) {
		return productService.addorUpdateProduct(product);
	}
	
	@DeleteMapping("/admin/{id}")
	public String deleteProductById(@PathVariable("id") Long id) {
		return productService.deleteProduct(id);
	}
}
