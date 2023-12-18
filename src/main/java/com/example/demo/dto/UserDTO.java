package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	    private int userid;
	    @NotBlank(message = "name shouldn't be null or empty")
	    private String username;
	    @Email(message = "invalid email format")
	    private String email;
	    private String password;
	    
	} 

