package com.example.demo.dto;

import jakarta.validation.constraints.Email;

public class LoginDTO {
	@Email(message = "invalid email id")	
	private String email;

	private String password;
	public LoginDTO() {
	}
	public LoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
