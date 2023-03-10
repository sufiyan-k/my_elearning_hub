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
@Table(name="chapters")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chapterId;

	@Column(name = "chapter_index_no")
	private String chapterIndexNo;

	@Column(name = "chapter_title")
	private String chapterTitle;

	@Column(name = "chapter_desc")
	private String chapterDesc;
	
	@Column(name = "chapter_thumb_path")
	private String chapterThumbPath;
	
	@Column(name = "chapter_file_path")
	private String chapterFilePath;
	
	
	@Column(name = "chapter_video_path")
	private String chapterVideoPath;
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;   // topics * <-------> 1 course
	
	@JsonIgnore 
	@OneToMany(mappedBy = "chapter",cascade = CascadeType.ALL)   // topic 1 <-------> * subtopics
	private List<SubTopic> subtopics;
	
	
	public Topic() {
		super();
	}
	
	public Topic(Long chapterId, String chapterIndexNo, String chapterTitle, String chapterDesc,
			String chapterThumbPath, String chapterFilePath, String chapterVideoPath, Course course,
			List<SubTopic> subtopics) {
		super();
		this.chapterId = chapterId;
		this.chapterIndexNo = chapterIndexNo;
		this.chapterTitle = chapterTitle;
		this.chapterDesc = chapterDesc;
		this.chapterThumbPath = chapterThumbPath;
		this.chapterFilePath = chapterFilePath;
		this.chapterVideoPath = chapterVideoPath;
		this.course = course;
		this.subtopics = subtopics;
	}


	public Long getChapterId() {
		return chapterId;
	}


	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}


	public String getChapterIndexNo() {
		return chapterIndexNo;
	}


	public void setChapterIndexNo(String chapterIndexNo) {
		this.chapterIndexNo = chapterIndexNo;
	}


	public String getChapterTitle() {
		return chapterTitle;
	}


	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}


	public String getChapterDesc() {
		return chapterDesc;
	}


	public void setChapterDesc(String chapterDesc) {
		this.chapterDesc = chapterDesc;
	}


	public String getChapterThumbPath() {
		return chapterThumbPath;
	}


	public void setChapterThumbPath(String chapterThumbPath) {
		this.chapterThumbPath = chapterThumbPath;
	}


	public String getChapterFilePath() {
		return chapterFilePath;
	}


	public void setChapterFilePath(String chapterFilePath) {
		this.chapterFilePath = chapterFilePath;
	}


	public String getChapterVideoPath() {
		return chapterVideoPath;
	}


	public void setChapterVideoPath(String chapterVideoPath) {
		this.chapterVideoPath = chapterVideoPath;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public List<SubTopic> getSubtopics() {
		return subtopics;
	}


	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}

	
	
	
}
