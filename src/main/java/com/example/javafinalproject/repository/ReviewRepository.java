package com.example.javafinalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.Review;

public interface ReviewRepository extends CrudRepository <Review, Long> {
    List<Review> findByStatus(String status);
    Optional<Review> findById(Long id);
    List<Review> findByRestaurantId(Long restaurantId);
    
}
