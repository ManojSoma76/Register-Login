package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	    private int userid;
	    @NotBlank(message = "name shouldn't be null or empty")
	    @Pattern(regexp = "^[a-zA-Z]+$",message = "username must contain only letter")
	    private String username;
	    @Email(message = "invalid email format")
	    private String email;
	    @NotBlank(message = "password shouldn't be null or empty")
	    private String password;
	    
	} 

