package com.example.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users_category")
public class UserCategory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catId")
	private Long categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
    @JsonIgnore
    @OneToMany(mappedBy = "category")   //category 1 <----------> * users
	private List<User> users;  

	public UserCategory() {
		super();
	}

	public UserCategory(Long categoryId, String categoryName) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
