package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.InstructorService;
import com.example.pojos.Course;
import com.example.pojos.SubTopic;
import com.example.pojos.Topic;

@RestController
@RequestMapping("/course")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	public InstructorController() {
		System.out.println("in course controller");
	}
	
	@PostMapping("/register")
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

	//getCourse list by inst_id
	
	
	
	
	

}
