package com.saivi.zuulgateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saivi.zuulgateway.entity.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String username);
}
