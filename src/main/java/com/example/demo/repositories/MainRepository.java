package com.example.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Fruit;


@Repository
public interface MainRepository extends ReactiveCrudRepository<Fruit, Long> {

}
