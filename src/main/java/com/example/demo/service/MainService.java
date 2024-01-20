package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Fruit;
import com.example.demo.repositories.MainRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * No funciona perfectamente con bases relacionales el repositorio, por eso metemos transformacion
 */
@Service
public class MainService {

	@Autowired
	private MainRepository repository;
	
	public Mono<Fruit> saveEntity(Fruit entity) {
		
		Fruit fruta = repository.save(entity);
		Mono<Fruit> monoFruta = Mono.just(fruta);
		
        return monoFruta;
    }
	
	public Flux<Fruit> getAll() {
		
		return Flux.fromIterable(repository.findAll());
		
		
	}
	
}
