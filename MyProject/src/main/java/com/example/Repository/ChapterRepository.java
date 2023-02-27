package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.Course;
import com.example.pojos.Topic;

public interface ChapterRepository extends JpaRepository<Topic, Long> {

}
