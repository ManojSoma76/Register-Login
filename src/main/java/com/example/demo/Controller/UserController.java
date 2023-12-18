package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.LoginResponse.LoginMesage;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.LoginDTO;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User saveEmployee(@RequestBody UserDTO userDTO)
    {
        User user = userService.addUser(userDTO);
        return user;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}