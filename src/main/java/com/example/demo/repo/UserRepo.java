package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.demo.Entity.User;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User,Integer>
{
	Optional<User> findOneByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}

