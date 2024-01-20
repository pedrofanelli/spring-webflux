package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Fruit;
import com.example.demo.service.MainService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class InternalController {

	@Autowired
	MainService service;
	
	@GetMapping("/internal/get")
	public Flux<Fruit> internalGet() {
		return service.getAll();
	}
	
	@PostMapping("/api/webflux")
	public Mono<Fruit> createFruit(@RequestBody Fruit fruit) {
		
		return service.saveEntity(fruit);
	}
}
