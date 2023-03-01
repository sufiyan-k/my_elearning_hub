package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequestDto {
	// data members MUST MATCH with JSON prop names
	@NotBlank(message = "username can't be blank!")
	@Length(min = 5,max=20,message = "Invalid username length!!!!!!!")
	private String username;
	
	@NotBlank(message = "password can't be blank!")
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or Invalid Password!!!!")
	private String password;
}
