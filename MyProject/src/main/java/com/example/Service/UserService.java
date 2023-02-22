package com.example.Service;

import java.util.List;

import com.example.pojos.User;

public interface UserService {
	public User addNewUser(User u);
	
	public List<User> getAllUsers();
	
	public User getById(Long id);

}
