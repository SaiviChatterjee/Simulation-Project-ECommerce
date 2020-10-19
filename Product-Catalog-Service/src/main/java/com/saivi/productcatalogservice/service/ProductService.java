package com.saivi.productcatalogservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saivi.productcatalogservice.entity.Product;
import com.saivi.productcatalogservice.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	public Product getProductById(Long id) {
		return repo.findById(id).orElse(new Product());
	}
	
	public Product addorUpdateProduct(Product product) {
		return repo.save(product);
	}
	
	public String deleteProduct(Long id) {
		repo.deleteById(id);
		return "Product deleted";
	}
}
