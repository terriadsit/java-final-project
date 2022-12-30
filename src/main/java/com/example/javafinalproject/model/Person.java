package com.example.javafinalproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity

public class Person {
    

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(unique=true)
    private String displayName;
    private String city;
    private String state;
    private String zip;
    private Boolean eggInterest;
    private Boolean peanutInterest;
    private Boolean dairyInterest;
    private Boolean admin;

    public Person(String displayName, String city, String state, String zip, Boolean eggInterest, Boolean dairyInterest, Boolean peanutInterest, Boolean admin) {
        this.displayName = displayName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.eggInterest = eggInterest;
        this.dairyInterest = dairyInterest;
        this.peanutInterest = peanutInterest;
    }
}
