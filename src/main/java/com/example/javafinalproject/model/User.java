package com.example.javafinalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String displayName;
    private String city;
    private String state;
    private String zip;
    private Boolean eggInterest;
    private Boolean peanutInterest;
    private Boolean dairyInterest;
    private Boolean admin;



    public User(User user) {
        this.displayName = user.getDisplayName();
        this.city = user.getCity();
        this.state = user.getState();
        this.zip = user.getZip();
        this.eggInterest = user.getEggInterest();
        this.dairyInterest = user.getDairyInterest();
        this.peanutInterest = user.getPeanutInterest();
        this.admin = user.getAdmin();
    }

    public User(String displayName, String city, String state, String zip, Boolean eggInterest, Boolean peanutInterest,
            Boolean dairyInterest, Boolean admin) {
        this.displayName = displayName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.eggInterest = eggInterest;
        this.peanutInterest = peanutInterest;
        this.dairyInterest = dairyInterest;
        this.admin = admin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Boolean getEggInterest() {
        return eggInterest;
    }

    public void setEggInterest(Boolean eggInterest) {
        this.eggInterest = eggInterest;
    }

    public Boolean getPeanutInterest() {
        return peanutInterest;
    }

    public void setPeanutInterest(Boolean peanutInterest) {
        this.peanutInterest = peanutInterest;
    }

    public Boolean getDairyInterest() {
        return dairyInterest;
    }

    public void setDairyInterest(Boolean dairyInterest) {
        this.dairyInterest = dairyInterest;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
