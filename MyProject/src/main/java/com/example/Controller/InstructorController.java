package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.InstructorService;
import com.example.pojos.Course;
import com.example.pojos.SubTopic;
import com.example.pojos.Topic;
import com.example.pojos.User;

@RestController
@RequestMapping("/api/elearning")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	public InstructorController() {
		System.out.println("in course controller");
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@RequestBody Course newCourse) {
		
		return instructorService.addNewCourse(newCourse);
		
	}
	@GetMapping("/courselist")
	public List<Course> getAllCourses(){
		return instructorService.getAllCourses();
	}
	
	//addChapter
	@PostMapping("/addchapter")
	public String addChapter(@RequestBody Topic newTopic) {
		return instructorService.addNewChapter(newTopic);
	}
	
	//addSubtopic
	@PostMapping("/addsubtopic")
	public String addSubtopic(@RequestBody SubTopic newTopic) {
		return instructorService.addNewSubTopic(newTopic);
	}

	// ======================== GET LISTS========================================

	//get course list by instid
	@GetMapping("/getcourses")
	public List<Course> getCoursesByInstructor(@RequestBody User user){
		return instructorService.getCoursesByInstid(user.getUserId());
	}
	
	//get chapters by courseid
	@GetMapping("/getchapters/{cid}")
	public List<Topic> getChaptersByCourse(@RequestParam long cid){
		//return instructorService.getChaptersByCourseid(course.getCourseId());
		return instructorService.getChaptersByCourseid(cid);

	}
	
	//get subtopics by chapterid
	@GetMapping("/getsubtopics/{chpid}")
	public List<SubTopic> getSubTopicsByChapter(@RequestParam long chpid){
		return instructorService.getSubTopicByChapterid(chpid);

	}
	
	

}
