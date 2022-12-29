package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Review {
 
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int peanut;
    private int egg;
    private int dairy;
    private String commentary;
    private Status status;

    public Review(Review review) {
        this.name = review.getName();
        this.peanut = review.getPeanut();
        this.egg = review.getEgg();
        this.peanut = review.getPeanut();
        this.commentary = review.getCommentary();
        this.status = review.getStatus();
    }

    public Review(String name, int peanut, int egg, int dairy, String commentary, Status status) {
        this.name = name;
        this.peanut = peanut;
        this.egg = egg;
        this.dairy = dairy;
        this.commentary = commentary;
        this.status = status;
    }

    
}
