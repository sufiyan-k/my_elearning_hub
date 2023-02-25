package com.example.Service;

import java.util.List;

import com.example.pojos.Course;


public interface CourseService {
	String addNewCourse(Course c);
	
	List<Course> getAllCourses();
	
	List<Course> getAllCoursesByCatid(long catid);


}
