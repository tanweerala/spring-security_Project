package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.repositories.UserRepository;

@RestController
public class AccountController 
{
	@Autowired
	private UserRepository repo;
	
}
