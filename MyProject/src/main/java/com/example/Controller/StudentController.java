package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.InstructorService;
import com.example.Service.StudentService;
import com.example.pojos.Course;
import com.example.pojos.EnrolledCourses;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/learning")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private InstructorService courseService;

	public StudentController() {
		System.out.println("in student controller");
	}
	
	// save course enrollment and email
	@PostMapping("/student/enrollment")
	public String enrollToCourse(@RequestBody EnrolledCourses e) {
		
		return studentService.enrollToCourse(e);
	}
	
	//get enrolled course list
	@GetMapping("/student/enrolled/courses/{userId}")
	public List<EnrolledCourses> getEnrolledCourseList(@PathVariable Long userId){
		return studentService.getAllEnrolledCourses(userId);
	}
	
	//get courses by cat id
	@GetMapping("/student/getcourses/{courseCatId}")
	public List<Course> getCoursesByCatid(@PathVariable Long courseCatId){
		
		return courseService.getAllCoursesByCatid(courseCatId);
		
	}
	// ------------------------- PLACE ORDER ----------------------------------
	

}
