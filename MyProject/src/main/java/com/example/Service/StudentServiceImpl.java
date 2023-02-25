package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Repository.StudentRepository;
import com.example.pojos.EnrolledCourses;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public String enrollToCourse(EnrolledCourses e) {
		studentRepo.save(e);
		return "Enrollement to course is done successfully";
	}

	@Override
	public List<EnrolledCourses> getAllEnrolledCourses(Long sid) {
		return studentRepo.findBySid(sid);
	}
	
	
	
}
