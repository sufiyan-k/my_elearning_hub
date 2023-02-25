package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.CourseService;
import com.example.Service.StudentService;
import com.example.pojos.Course;
import com.example.pojos.EnrolledCourses;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/learning")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;

	public StudentController() {
		System.out.println("in student controller");
	}
	
	//enroll to course
	@PostMapping("/student/enroll")
	public String enrollToCourse(@RequestBody EnrolledCourses e) {
		
		return studentService.enrollToCourse(e);
	}
	
	//get enrolled course list
	@GetMapping("/student/courselist/{sid}")
	public List<EnrolledCourses> getEnrolledCourseList(@PathVariable Long sid){
		return studentService.getAllEnrolledCourses(sid);
	}
	
	//get courses by cat id
	@GetMapping("/student/getcourses/{catid}")
	public List<Course> getCoursesByCatid(@PathVariable Long catid){
		
		return courseService.getAllCoursesByCatid(catid);
		
	}
	
	

}
