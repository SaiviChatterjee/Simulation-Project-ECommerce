package com.saivi.productcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductCatelogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatelogServiceApplication.class, args);
	}

}
