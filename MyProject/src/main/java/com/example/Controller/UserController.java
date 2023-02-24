package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/register")
	public String addUser(@RequestBody User u) {
		return userService.addNewUser(u);
	}
	
	//login
	@PostMapping("/login")
	public User userLogin(@RequestParam String username,@RequestParam String password) {
			
		User user=userService.getUser(username, password);
			
		if(user!=null) {
			System.out.println("Welcome");
			System.out.println(user.toString());
			return user;
		}
		else {
			System.out.println("invalid user");
		}
		return null;
			
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
