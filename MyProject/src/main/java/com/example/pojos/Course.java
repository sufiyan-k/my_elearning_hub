package com.example.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@Column(name = "course_title")
	private String courseTitle;

	@Column(name = "course_desc")
	private String courseDesc;
	
	@Column(name = "course_type")    // paid or free
	private String courseType;
	
	@Column(name = "course_price")
	private Float coursePrice;
	
	@Column(name = "course_thumb_path")
	private String courseThumbPath;
	
	@Column(name = "intro_video_path")
	private String introVideoPath;
	
	@ManyToOne
	@JoinColumn(name="catid")
	private CourseCategory category;    //many courses can have same category
	
	
    @JsonIgnore
	@ManyToOne           
	@JoinColumn(name="userid")
	private User user;  //many courses belong to single user(userId)  course * <-------> 1 users
	
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade=CascadeType.ALL) 
	private List<Topic> topics;  //course have list of topics  course 1 <-------> * topics
	
    @JsonIgnore
	@OneToMany(mappedBy = "courseid",cascade=CascadeType.ALL)
	private List<SubTopic> subtopics; //course have list of subtopics  course 1 <-------> * subtopics

	
	public Course() {
		super();
	}

	public Course(Long courseId, String courseTitle, String courseDesc, String courseType, Float coursePrice,
			String courseThumbPath, String introVideoPath, CourseCategory category, User user) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.courseType = courseType;
		this.coursePrice = coursePrice;
		this.courseThumbPath = courseThumbPath;
		this.introVideoPath = introVideoPath;
		this.category = category;
		this.user = user;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Float getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Float coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseThumbPath() {
		return courseThumbPath;
	}

	public void setCourseThumbPath(String courseThumbPath) {
		this.courseThumbPath = courseThumbPath;
	}

	public String getIntroVideoPath() {
		return introVideoPath;
	}

	public void setIntroVideoPath(String introVideoPath) {
		this.introVideoPath = introVideoPath;
	}

	public CourseCategory getCategory() {
		return category;
	}

	public void setCategory(CourseCategory category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<SubTopic> getSubtopics() {
		return subtopics;
	}

	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc
				+ ", courseType=" + courseType + ", coursePrice=" + coursePrice + ", courseThumbPath=" + courseThumbPath
				+ ", introVideoPath=" + introVideoPath + "]";
	}
	

}
