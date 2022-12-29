package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Float eggReview;
    private Float dairyReview;
    private Float peanutReview;

    public Restaurant(String name, Float eggRevFloat, Float dairyReview, Float peanutReview) {
        this.name = name;
    }
    
  
}
