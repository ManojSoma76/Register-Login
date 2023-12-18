package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.LoginResponse.LoginMesage;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.LoginDTO;

public interface UserService {
	
    User addUser(UserDTO userDTO);
    LoginMesage loginUser(LoginDTO loginDTO);
}
