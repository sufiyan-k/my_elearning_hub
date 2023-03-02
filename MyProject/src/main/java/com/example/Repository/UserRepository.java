package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserNameAndPass(String em,String pass);
	
	@Query(value="select u.category.name from User u where u.category.id=?1", nativeQuery=false)
	String getRoleNameByUserid(long userid);
	
	@Query(value="select u.userId from User u where u.userName=?1", nativeQuery=false)
	String getUserIdByUserName(String username);
	
	
}
