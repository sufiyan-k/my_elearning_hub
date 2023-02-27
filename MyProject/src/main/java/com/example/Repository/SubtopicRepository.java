package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.Course;
import com.example.pojos.SubTopic;

public interface SubtopicRepository extends JpaRepository<SubTopic, Long> {
	
	

}
