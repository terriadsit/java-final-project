package com.example.javafinalproject.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.javafinalproject.repository.RestaurantRepository;
import com.example.javafinalproject.repository.ReviewRepository;
import com.example.javafinalproject.repository.UserRepository;
import com.example.javafinalproject.model.*;

@RestController
public class ProjectController {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public ProjectController(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such restaurant");
        } else {
            return restaurantOptional.get();
        }
    }

    @PostMapping("/restaurant/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }
 
    
}
