package com.saivi.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saivi.userservice.Entity.User;
import com.saivi.userservice.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	public User getUserById(Long id) {
		return repo.findById(id).orElse(new User());
	}
	
	public User addOrUpdate(User user) {
		repo.save(user);
		return user;
	}
	
	public String delete(Long id) {
		repo.deleteById(id);
		return "User deleted";
	}

	
}
