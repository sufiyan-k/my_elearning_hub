package com.example.Service;

import java.util.List;

import com.example.pojos.EnrolledCourses;

public interface StudentService {
	
	String enrollToCourse(EnrolledCourses e);
	
	List<EnrolledCourses> getAllEnrolledCourses(Long sid);

}
