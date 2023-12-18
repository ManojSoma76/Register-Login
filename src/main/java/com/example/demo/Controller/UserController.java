package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.LoginResponse.LoginMesage;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;

import jakarta.validation.Valid;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.ResponseDTO;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired(required = true)
//    private ResponseDTO dto;
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> saveEmployee(@Valid @RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO();  // Create ResponseDTO instance
        try {
            User user = userService.addUser(userDTO);
            ResponseDTO.Data responseData = new ResponseDTO.Data();
            responseData.setUserid(user.getUserid());
            responseData.setUserName(user.getUsername());
            responseData.setEmail(user.getEmail());
            responseData.setPassword(user.getPassword());

            responseDTO.setStatuscode(200);
            responseDTO.setStatus("SUCCESS");
            responseDTO.setData(responseData);
        } catch (Exception e) {
            responseDTO.setStatuscode(500);
            responseDTO.setStatus("FAILURE");
            responseDTO.setData(null);
        }
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser( @Valid @RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}