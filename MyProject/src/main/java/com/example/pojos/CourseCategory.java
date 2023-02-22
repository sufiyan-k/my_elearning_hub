package com.example.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course_category")
public class CourseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="catid")
	private Long categoryId;  //1 2 3 4
	
	@Column(name="category_name")
	private String categoryName;  //tech science food psychology
	
    @OneToMany(mappedBy = "category")
	private List<Course> courses;

	public CourseCategory() {
		super();
	}

	public CourseCategory(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CourseCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
}
