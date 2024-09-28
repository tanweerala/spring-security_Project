package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.User;
import com.cetpa.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder pe;
	
	@PostMapping("add")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		String pass=user.getPassword();
		String epass=pe.encode(pass);
		user.setPassword(epass);
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
