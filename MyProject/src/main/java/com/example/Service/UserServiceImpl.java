package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Repository.UserRepository;
import com.example.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addNewUser(User u) {
		return userRepo.save(u);
		
	}
	@Override
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public User getById(Long id) {
		return userRepo.findById(id).orElseThrow();
	}
	

}
