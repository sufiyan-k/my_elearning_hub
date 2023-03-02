package com.example.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private Long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

    //@JsonIgnore
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne                       //users * <----------> 1 category
	@JoinColumn(name="catid")
	private Category category;   //many user will have same category
	
	@OneToMany(mappedBy="user")   
	private List<Course> courseEnrolled;  //single user can have  many courses  users 1 <-----> * courses

	public User() {
		super();
		System.out.println("in users constructor");
	}
	
	
	//added this constructor
	public User(Long userId) {
		super();
		this.userId = userId;
	}

	public User(Long userId, String userName, String firstName, String lastName, String email, String pass,
			String phoneNo, String address, Category category, List<Course> courseEnrolled) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass = pass;
		this.phoneNo = phoneNo;
		this.address = address;
		this.category = category;
		this.courseEnrolled = courseEnrolled;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Course> getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(List<Course> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", pass=" + pass + ", phoneNo=" + phoneNo + ", "
						+ "address=" + address + "]";
	}
	
	

	
	
	
	

}
