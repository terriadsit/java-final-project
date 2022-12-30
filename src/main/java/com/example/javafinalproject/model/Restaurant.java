package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "zip" }) })
@Getter @Setter @NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String zip;
    private Float eggReview;
    private Float dairyReview;
    private Float peanutReview;

    public Restaurant(String name, String zip, Float eggReview, Float dairyReview, Float peanutReview) {
        this.name = name;
        this.zip = zip;
        this.eggReview = eggReview;
        this.dairyReview = dairyReview;
        this.peanutReview = peanutReview;
    }
    
  
}
