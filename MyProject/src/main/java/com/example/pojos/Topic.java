package com.example.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="chapter")
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
	
	
	@ManyToOne
	private Course course;   // topics * <-------> 1 course
	
	
	@OneToMany(mappedBy = "chapter",cascade = CascadeType.ALL)   // topic 1 <-------> * subtopics
	private List<SubTopic> subtopics;

}
