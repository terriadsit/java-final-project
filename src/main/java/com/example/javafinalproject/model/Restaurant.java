package com.example.javafinalproject.model;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "zip" }) })
@Getter @Setter @NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String zip;
    private double eggReview;
    private double dairyReview;
    private double peanutReview;

    public Restaurant(String name, String zip, double eggReview, double dairyReview, double peanutReview) {
        this.name = name;
        this.zip = zip;
        this.eggReview = eggReview;
        this.dairyReview = dairyReview;
        this.peanutReview = peanutReview;
    }
    
  
}
