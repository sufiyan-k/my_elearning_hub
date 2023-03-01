package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.UserService;
import com.example.dto.LoginRequestDto;
import com.example.pojos.User;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
	
	public UserController() {
		System.out.println("in user controller");
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String addUser(@RequestBody User u) {
		return userService.addNewUser(u);
	}
	
	//login
	@PostMapping("/login")
	public User userLogin(@RequestBody @Valid LoginRequestDto dto) {
			
		User user=userService.getUser(dto.getUsername(), dto.getPassword());		
		return user;		
	}
	
	// =================== ADMIN FUNCTIONALITY =========================

//	--------------- Manage Users --------------------------------
	
	@GetMapping("/admin/users")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	//delete

	
	

}
