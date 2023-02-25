package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.EnrolledCourses;

public interface StudentRepository extends JpaRepository<EnrolledCourses, Long> {
	
	 List<EnrolledCourses> findBySid(Long sid);
	

}
