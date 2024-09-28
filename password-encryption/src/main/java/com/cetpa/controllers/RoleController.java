package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.UserRole;
import com.cetpa.repositories.RoleRepository;

@RestController
@RequestMapping("role")
public class RoleController 
{
	@Autowired private RoleRepository roleRepository; 
	
	@PostMapping("add")
	public ResponseEntity<UserRole> addRole(@RequestBody UserRole role)
	{
		roleRepository.save(role);
		return ResponseEntity.status(HttpStatus.CREATED).body(role);
	}
}
