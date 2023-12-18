package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.LoginResponse.LoginMesage;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.repo.UserRepo;

import java.util.Optional;
@Service
public class UserIMPL implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User addUser(UserDTO userDTO) {
		User user = new User(
				userDTO.getUserid(),
				userDTO.getUsername(),
				userDTO.getEmail(),
				this.passwordEncoder.encode(userDTO.getPassword())
				);
		User u=userRepo.save(user);
		return u;
	}
	UserDTO userDTO;
	@Override
	public LoginMesage  loginUser(LoginDTO loginDTO) {
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if (user1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if (user.isPresent()) {
					return new LoginMesage("Login Success");
				} else {
					return new LoginMesage("Login Failed");
				}
			} else {
				return new LoginMesage("password incorrect");
			}
		}else {
			return new LoginMesage("Email does not exits");
		}
	}
}
