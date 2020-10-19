package com.saivi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.saivi.userservice.UserServiceApplication;
import com.saivi.userservice.Entity.User;
import com.saivi.userservice.Repository.UserRepository;
import com.saivi.userservice.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = UserServiceApplication.class)
@RunWith(SpringRunner.class)
class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getAllUserTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(1L, "saivi", "abc", "ADMIN", true), new User(2L, "saivi", "abc", "USER", true)).collect(Collectors.toList()));
		assertEquals(2, service.getAllUsers().size());
	}
	
	@Test
	public void getUserByIdTest() {
		 Optional<User> user= Optional.of(new User(1L, "saivi", "abc", "ADMIN", true));
		 Long id = 1L; 
		 when(repository.findById(id)).thenReturn(user);
		 assertEquals(user.orElse(null), service.getUserById(id));
	}
	
	@Test
	public void addOrUpdateUserTest() {
		User user = new User(1L, "saivi", "abc", "ADMIN", true);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addOrUpdate(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User(1L, "saivi", "abc", "ADMIN", true);
		service.delete(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}
}