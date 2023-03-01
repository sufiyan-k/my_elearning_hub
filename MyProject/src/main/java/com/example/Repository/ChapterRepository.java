package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pojos.Course;
import com.example.pojos.Topic;


public interface ChapterRepository extends JpaRepository<Topic, Long> {
	
	//from topic we are accessing course and displaying list of topics 
	@Query(value="select t from Topic t where t.course.courseId=?1",nativeQuery=false)
	List<Topic> getChaptersByCourseid(long cid);

}
