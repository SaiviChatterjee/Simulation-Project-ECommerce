package com.saivi.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saivi.orderservice.entity.OrderItems;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, Long>{

	List<OrderItems> findAllByUserId(Long id);
}
