package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pojos.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long>{
	
//	//@Query(value="select c from Course c where c.category.categoryId=?1")
//	@Query(value = "SELECT * FROM projectdb.course where course_category_cat_id=?1", nativeQuery = true)
	
}
