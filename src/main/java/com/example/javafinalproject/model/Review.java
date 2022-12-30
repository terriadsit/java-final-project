package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Review {
 
    @Id
    @GeneratedValue
    private Long id;
    private String displayName;
    private Long restaurantId;
    private int peanut;
    private int egg;
    private int dairy;
    private String commentary;
    private String status;

    public Review(Review review) {
        this.displayName = review.getDisplayName();
        this.restaurantId = review.getRestaurantId();
        this.peanut = review.getPeanut();
        this.egg = review.getEgg();
        this.peanut = review.getPeanut();
        this.commentary = review.getCommentary();
        this.status = review.getStatus();
    }

    public Review(String displayName,Long restaurantId, int peanut, int egg, int dairy, String commentary, String status) {
        this.displayName = displayName;
        this.restaurantId = restaurantId;
        this.peanut = peanut;
        this.egg = egg;
        this.dairy = dairy;
        this.commentary = commentary;
        this.status = status;
    }

    
}
