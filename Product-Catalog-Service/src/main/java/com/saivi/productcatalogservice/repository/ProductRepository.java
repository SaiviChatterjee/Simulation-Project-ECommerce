package com.saivi.productcatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saivi.productcatalogservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
