package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pojos.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query(value="select c from Course c where c.category.categoryId=?1", nativeQuery=false)
	List<Course> getCoursesByCategory(long catid);
	
	
	
}
