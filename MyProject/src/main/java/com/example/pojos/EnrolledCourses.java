package com.example.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enroll")
public class EnrolledCourses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollId;

	@Column(name = "sid")
	private Long sid;

	@Column(name = "title")
	private String courseTitle;

	@Column(name = "course_type")
	private String courseType; // paid or free

	@Column(name = "cid")
	private Long cid;

	public EnrolledCourses() {
		super();
	}

	public EnrolledCourses(Long enrollId, Long sid, String courseTitle, String courseType, Long cId) {
		super();
		this.enrollId = enrollId;
		this.sid = sid;
		this.courseTitle = courseTitle;
		this.courseType = courseType;
		this.cid = cId;
	}

	public Long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(Long enrollId) {
		this.enrollId = enrollId;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Long getcId() {
		return cid;
	}

	public void setcId(Long cId) {
		this.cid = cId;
	}
	
	

}
