package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int peanut;
    private int egg;
    private int dairy;
    private String commentary;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPeanut() {
        return peanut;
    }
    public void setPeanut(int peanut) {
        this.peanut = peanut;
    }
    public int getEgg() {
        return egg;
    }
    public void setEgg(int egg) {
        this.egg = egg;
    }
    public int getDairy() {
        return dairy;
    }
    public void setDairy(int dairy) {
        this.dairy = dairy;
    }
    public String getCommentary() {
        return commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }


}
