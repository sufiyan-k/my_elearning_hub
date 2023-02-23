package com.example.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.CourseRepository;
import com.example.pojos.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String addNewCourse(Course c) {
		 String mesg;
		 courseRepo.save(c);
		 mesg="Course added successfully "+ c.getCourseTitle();
		 return mesg;
		 
	}
	

}