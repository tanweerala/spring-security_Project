package com.cetpa;

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
		return "API add called";
	}
	@GetMapping("delete")
	public String deleteUser()
	{
		return "API delete called";
	}
	@GetMapping("show")
	public String showUser()
	{
		return "API show called";
	}
}
