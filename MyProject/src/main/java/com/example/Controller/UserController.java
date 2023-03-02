package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.InstructorService;
import com.example.Service.UserService;
import com.example.dto.LoginRequestDto;
import com.example.pojos.Course;
import com.example.pojos.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Validated
@RequestMapping("/api/elearning")
public class UserController {
	
	public UserController() {
		System.out.println("in user controller");
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/register")
	public String addUser(@RequestBody User u) {
		System.out.println("in register");
		return userService.addNewUser(u);
	}
	
	//login
//	@PostMapping("/login")
//	public User userLogin(@RequestBody @Valid LoginRequestDto dto) {
//			
//		User user=userService.getUser(dto.getUsername(), dto.getPassword());		
//		return user;		
//	}
	
	@PostMapping("/login")
	public User userLogin(@RequestBody User obj) {
		System.out.println("inside login");	
		User user=userService.getUser(obj.getUserName(), obj.getPass());
		System.out.println("username"+ obj.getUserName());
		return user;		
	}
	
	
	// get rolename by username
	@PostMapping("/rolename")           // checking the user role it is Student or Instructor or Admin 
	public String getUserRoleName(@RequestBody User user) {
		System.out.println("rolename=" + user.getUserId());
		return userService.getUserRoleByUserid(user.getUserId());
	
	}
	
	//find userid by username
	@PostMapping("/user/getuid/{userInfo}")
	public String getUserIdByUserName(@PathVariable String userInfo) {

		String result = userService.getUserIdByUserName(userInfo);

		return result;
	}
	
	@PostMapping("/getuid")
	public String getUserIdByUserName(@RequestBody User user) {
		System.out.println("username=" + user.getUserName());
		String result = userService.getUserIdByUserName(user.getUserName());
		System.out.println(result);
		return result;
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
	
	//delete user 
	@DeleteMapping("admin/deleteuser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUserByUserid(id);
		// we are returning string from here in frontend it will be display as alert msg
	}
//	--------------- Manage Users End--------------------------------

//	--------------- Manage Course --------------------------------
	
	@GetMapping("/admin/courses")
	public List<Course> getAllCourses(){
		return instructorService.getAllCourses();
	}

	

}
