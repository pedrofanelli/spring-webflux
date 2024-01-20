package com.example.demo.controllers;


import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.Fruit;
import com.example.demo.service.MainService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * Podriamos armar todo el camino: controller -> service -> repository manejandonos con Mono/Flux
 * 
 * Al retornar un Flux, vemos que no hacemos .subscribe(), eso porque se hace automáticamente.
 * 
 * Lo interesante es que, si todo esta armado como dije más arriba, al entrar al controller, se retorna 
 * el Flux de forma automática, aunque todavía ni se hubiera pegado a la base. Cuando se obtenga la data
 * se enviará al Flux y se recibirá, ahi esta el potencial!
 * 
 * DATO IMPORTANTE: No funciona con JPA, pero es usable con Redis! Todo el manejo de posible cache con eso
 * 
 * Vamos a trabajar igual haciendo un "bridge" en el servicio
 * 
 */
@Controller
public class MainControllers {

	@Autowired
	MainService service;
	
	@Autowired
	WebClient webClient;
	
	@GetMapping("/api/webflux")
	public String mainController(Model model) {
		
		Flux<Fruit> fruits = webClient
				.get()
				.uri("/internal/get")
				.retrieve()
				.bodyToFlux(Fruit.class)
				.delayElements(Duration.ofSeconds(2));
			
		/*
		fruits.subscribe(x -> System.out.println(x.getName()),
				         error -> System.out.println(error.getMessage()));
		*/
	
		
		model.addAttribute("fruits", fruits);
		
		
		return "fruta";	
		
	}
	
	
	
	
	
	
	
	
}
