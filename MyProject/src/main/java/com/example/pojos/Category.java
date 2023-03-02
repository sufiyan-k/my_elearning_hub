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
public class Category {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catId")
	private Integer id;
	
	@Column(name="category_name")
	private String name;
	
//    @JsonIgnore
    @OneToMany(mappedBy = "category")   //category 1 <----------> * users
	private List<User> users;  

	public Category() {
		super();
	}
	

	public Category(Integer id) {
		super();
		this.id = id;
	}


	public Category(Integer id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
	

}
