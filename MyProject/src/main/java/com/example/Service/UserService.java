package com.example.Service;

import java.util.List;

import com.example.pojos.User;

public interface UserService {
	String addNewUser(User u);
	
	List<User> getAllUsers();
	
	User getById(Long id);
	
	User getUser(String em,String pass);
	
	String deleteUserByid(Long id);

}
