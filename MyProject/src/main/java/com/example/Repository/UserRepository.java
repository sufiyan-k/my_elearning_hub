package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserNameAndPassword(String em,String pass);
	
	
}
