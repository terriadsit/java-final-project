package com.example.javafinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
        
    Optional<Restaurant> getById(Long id);
    List<Restaurant> findByEggReviewIsNotNullAndZipIsOrderByEggReviewDesc(String zip);
    List<Restaurant> findByDairyReviewIsNotNullAndZipIsOrderByDairyReviewDesc(String zip);
    List<Restaurant> findByPeanutReviewIsNotNullAndZipIsOrderByPeanutReviewDesc(String zip);
  
 }
