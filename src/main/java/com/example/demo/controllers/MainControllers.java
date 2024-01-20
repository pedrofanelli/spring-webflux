package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControllers {

	@GetMapping("/api/webflux")
	public String mainController() {
		return "WebFlux!!!";
	}
	
}
