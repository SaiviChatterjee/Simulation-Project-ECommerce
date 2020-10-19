package com.saivi.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saivi.userservice.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
