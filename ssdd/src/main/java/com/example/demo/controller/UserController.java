package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/user/{uiNo}")
	public Map<String, String> getUser(@PathVariable int uiNo) {
		Map<String, String> user = new HashMap<>();
		return user;
	}
}
