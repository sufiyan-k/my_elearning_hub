package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.UserService;
import com.example.pojos.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public UserController() {
		System.out.println("in user controller");
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User addUser(@RequestBody User u) {
		return userService.addNewUser(u);
	}
	
	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}

}
