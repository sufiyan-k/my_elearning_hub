package com.example.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.ChapterRepository;
import com.example.Repository.CourseRepository;
import com.example.Repository.SubtopicRepository;
import com.example.pojos.Course;
import com.example.pojos.SubTopic;
import com.example.pojos.Topic;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ChapterRepository chapterRepo;
	
	@Autowired
	private SubtopicRepository subTopicRepo;
	

	@Override
	public String addNewCourse(Course c) {
		 String mesg;
		 courseRepo.save(c);
		 mesg="Course added successfully "+ c.getCourseTitle();
		 return mesg;
		 
	}
	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}
	
	@Override
	public List<Course> getAllCoursesByCatid(long catid) {
		return courseRepo.getCoursesByCategory(catid);
	}
	
	@Override
	public String addNewChapter(Topic top) {
		 chapterRepo.save(top);
		 return "Chapter added successfully "+ top.getChapterTitle() ;
	}
	@Override
	public String addNewSubTopic(SubTopic st) {
		subTopicRepo.save(st);
		return "Subtopic added successfully "+ st.getSubtTitle() ;
	}
	
//	@Override
//	public Optional<Course> getCoursesByInstid(long instid) {
//		return courseRepo.findById(instid);
//	}
	
	
	
	
	

	
	
	

}
