package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

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
@RestController
public class MainControllers {

	@GetMapping("/api/webflux")
	public Flux<String> mainController() {
		
		String[] fruits = new String[] {"Apple", "Orange", "Grape", "Banana"};
		
		return Flux.fromArray(fruits);
		
		
	}
	
	
	
	
}
