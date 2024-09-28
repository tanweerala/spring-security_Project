package com.cetpa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	@GetMapping("add")
	public String addUser()
	{
		return "User added...";
	}
	@GetMapping("delete")
	public String deleteUser()
	{
		return "User deleted...";
	}
	@GetMapping("update")
	public String updateUser()
	{
		return "User updated...";
	}
	@GetMapping("list")
	public String getUserList()
	{
		return "User list...";
	}
}
