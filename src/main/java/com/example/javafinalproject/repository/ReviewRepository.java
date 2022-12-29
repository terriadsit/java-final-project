package com.example.javafinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.Review;

public interface ReviewRepository extends CrudRepository <Review, Long> {
    // TODO: Add a Review
    // TODO: Admin only get reviews that are pending
    // TODO: Admin only approve or reject a review;
    // TODO: fetch a given restaurants reviews
}
