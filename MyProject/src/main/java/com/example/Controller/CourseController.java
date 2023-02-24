package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.CourseService;
import com.example.pojos.Course;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	public CourseController() {
		System.out.println("in course controller");
	}
	
	@PostMapping("/register")
	public String addCourse(@RequestBody Course newCourse) {
		
		return courseService.addNewCourse(newCourse);
		
	}
	@GetMapping("/courselist")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	
	
	

}
