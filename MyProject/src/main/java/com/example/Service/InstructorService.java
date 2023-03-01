package com.example.Service;

import java.util.List;

import com.example.pojos.Course;
import com.example.pojos.SubTopic;
import com.example.pojos.Topic;


public interface InstructorService {
	String addNewCourse(Course c);
	
	List<Course> getAllCourses();
	
	List<Course> getAllCoursesByCatid(long catid);
	
	String addNewChapter(Topic top);
	
	String addNewSubTopic(SubTopic st);
	
	List<Course> getCoursesByInstid(long instid);
	
	List<Topic> getChaptersByCourseid(long cid);

	List<SubTopic> getSubTopicByChapterid(long chpid);

}
