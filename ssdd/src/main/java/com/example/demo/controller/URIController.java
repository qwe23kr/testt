package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class URIController {
	@GetMapping("/views/**")
	public void goPage() {

	}

	@GetMapping("/")
	public String home() {
		return "views/index";
	}
}
