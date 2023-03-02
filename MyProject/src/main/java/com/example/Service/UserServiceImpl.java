package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Repository.UserRepository;
import com.example.custom_exceptions.ResourceNotFoundException;
import com.example.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String addNewUser(User u) {
		String mesg;
		userRepo.save(u);
		mesg="User registered successfully "+ u.getUserName();
		return mesg;
		
	}
	@Override
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public User getById(Long id) {
		return userRepo.findById(id).orElseThrow();
	}
	
	@Override
	public User getUser(String un, String pass) {
		// TODO Auto-generated method stub
		return userRepo.findByUserNameAndPass(un, pass)
				.orElseThrow(()-> new ResourceNotFoundException("invalid user"));
	}
	@Override
	public String deleteUserByid(Long id) {
		
		if (!userRepo.existsById(id)) {
			throw new com.example.custom_exceptions.ResourceNotFoundException("User doesnt exist");
		}
		userRepo.deleteById(id);
		return "User with id " + id + " has been deleted successfully";
	}
	@Override
	public String getUserRoleByUserid(long userid) {
		return userRepo.getRoleNameByUserid(userid);
	}
	@Override
	public String getUserIdByUserName(String username) {
		return userRepo.getUserIdByUserName(username);
	}
	@Override
	public String deleteUserByUserid(long userid) {
		
		if (!userRepo.existsById(userid)) {
			throw new com.example.custom_exceptions.ResourceNotFoundException("User is invalid");
		}
		 String mesg;
		 userRepo.deleteById(userid);
		 mesg="User deleted successfully";
		 return mesg;
	}
	
	
	
	
	

}
