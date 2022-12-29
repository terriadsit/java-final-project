package com.example.javafinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    // TODO: add a restaurant
    
    Optional<Restaurant> getById(Long id);
    // TODO: fetch all restaurants by zip which have at least one score for a given allergy sorted descending
}
