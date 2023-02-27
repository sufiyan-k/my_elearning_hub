package com.example.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="sub_topics")
public class SubTopic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subtId;

	@Column(name = "subt_index_no")
	private String subtIndexNo;

	@Column(name = "subt_title")
	private String subtTitle;

	@Column(name = "subt_desc")
	private String subtDesc;
	
	@Column(name = "subt_thumb_path")
	private String subtThumbPath;
	
	@Column(name = "subt_file_path")
	private String subtFilePath;
	
	@Column(name = "subt_video_path")
	private String subtVideoPath;
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="chapter_id")
	private Topic chapter;  // many subtopics belongs to one chapter chapter subtopic * <-------> 1 topic
	
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course courseid; //many subtopics belongs to one course  subtopic * <-------> 1 course

	public SubTopic() {
		super();
	}

	public SubTopic(Long subtId, String subtIndexNo, String subtTitle, String subtDesc, String subtThumbPath,
			String subtFilePath, String subtVideoPath, Topic topic, com.example.pojos.Course courseid) {
		super();
		this.subtId = subtId;
		this.subtIndexNo = subtIndexNo;
		this.subtTitle = subtTitle;
		this.subtDesc = subtDesc;
		this.subtThumbPath = subtThumbPath;
		this.subtFilePath = subtFilePath;
		this.subtVideoPath = subtVideoPath;
		this.chapter = topic;
		this.courseid = courseid;
	}

	public Long getSubtId() {
		return subtId;
	}

	public void setSubtId(Long subtId) {
		this.subtId = subtId;
	}

	public String getSubtIndexNo() {
		return subtIndexNo;
	}

	public void setSubtIndexNo(String subtIndexNo) {
		this.subtIndexNo = subtIndexNo;
	}

	public String getSubtTitle() {
		return subtTitle;
	}

	public void setSubtTitle(String subtTitle) {
		this.subtTitle = subtTitle;
	}

	public String getSubtDesc() {
		return subtDesc;
	}

	public void setSubtDesc(String subtDesc) {
		this.subtDesc = subtDesc;
	}

	public String getSubtThumbPath() {
		return subtThumbPath;
	}

	public void setSubtThumbPath(String subtThumbPath) {
		this.subtThumbPath = subtThumbPath;
	}

	public String getSubtFilePath() {
		return subtFilePath;
	}

	public void setSubtFilePath(String subtFilePath) {
		this.subtFilePath = subtFilePath;
	}

	public String getSubtVideoPath() {
		return subtVideoPath;
	}

	public void setSubtVideoPath(String subtVideoPath) {
		this.subtVideoPath = subtVideoPath;
	}

	public Topic getTopic() {
		return chapter;
	}

	public void setTopic(Topic topic) {
		this.chapter = topic;
	}

	public Course getCourseid() {
		return courseid;
	}

	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}

	@Override
	public String toString() {
		return "SubTopic [subtId=" + subtId + ", subtIndexNo=" + subtIndexNo + ", subtTitle=" + subtTitle
				+ ", subtDesc=" + subtDesc + ", subtThumbPath=" + subtThumbPath + ", subtFilePath=" + subtFilePath
				+ ", subtVideoPath=" + subtVideoPath + "]";
	}
	
	
	
	
}
