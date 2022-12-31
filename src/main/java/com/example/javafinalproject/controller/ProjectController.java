package com.example.javafinalproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.javafinalproject.repository.RestaurantRepository;
import com.example.javafinalproject.repository.PersonRepository;
import com.example.javafinalproject.repository.ReviewRepository;
import com.example.javafinalproject.model.*;

@Slf4j //lombok logger
@RestController
@RequestMapping("/")
public class ProjectController {
    private final RestaurantRepository restaurantRepository;
    private final PersonRepository personRepository;
    private final ReviewRepository reviewRepository;

    public ProjectController(RestaurantRepository restaurantRepository, PersonRepository personRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.personRepository = personRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such restaurant");
        } else {
            return restaurantOptional.get();
        }
    }

    @GetMapping("/restaurant/search")
    public List<Restaurant> searchRestaurants(@RequestParam(name="zip", required=false) String zip, @RequestParam(name="allergy", required=false) String allergy) {
        List<Restaurant> newList;
        switch (allergy){
            case "egg":
               newList = restaurantRepository.findByEggReviewIsNotNullAndZipIsOrderByEggReviewDesc(zip);
               break;
            case "dairy":
                newList = restaurantRepository.findByDairyReviewIsNotNullAndZipIsOrderByDairyReviewDesc(zip);
                break;
            case "peanut":
                newList = restaurantRepository.findByPeanutReviewIsNotNullAndZipIsOrderByPeanutReviewDesc(zip);
                break;
            default:
                newList = new ArrayList<>();
                break;
        }
        return newList;
    }

    @PostMapping("/restaurant/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @GetMapping("/person/search")
    public Person getPerson(@RequestParam(name="displayName", required=false) String displayName) {
        Optional<Person> personOptional = personRepository.findByDisplayName(displayName);
        if (!personOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such person"); 
        } else {
            Person person = personOptional.get();
            return person;
        }
     }

     @PostMapping("/person/add")
     public Person addPerson(@RequestBody Person person) {
        String displayName = person.getDisplayName();
        if (displayName != null) {
            Optional<Person> personOptional = personRepository.findByDisplayName(displayName);
            if (personOptional.isPresent()) {
                log.info("in personoption is present");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This display name is already in use"); 
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The display name is required."); 
        }
        log.info("'just before save person'");
        personRepository.save(person);
        return person;
     }

     @PutMapping("/person/{id}") 
     public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person p) {
        Optional<Person> personToUpdateOptional = personRepository.findById(id);
        if (!personToUpdateOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This id is not valid");
        } else {
            Person personToUpdate = personToUpdateOptional.get(); 
            if(p.getAdmin() != null) {
                personToUpdate.setAdmin(p.getAdmin());
            }
            if(p.getCity() != null) {
                personToUpdate.setCity(p.getCity());
            }
            if(p.getDairyInterest() != null) {
                personToUpdate.setDairyInterest(p.getDairyInterest());
            }
            if(p.getEggInterest() != null) {
                personToUpdate.setDairyInterest(p.getDairyInterest());
            }
            if(p.getPeanutInterest() != null) {
                personToUpdate.setPeanutInterest(p.getPeanutInterest());
            }
            if(p.getState() != null) {
                personToUpdate.setState(p.getState());
            }
            if(p.getZip() != null) {
                personToUpdate.setZip(p.getZip());
            }
            Person updatedPerson = personRepository.save(personToUpdate);
            return updatedPerson; 
        }
     }

     @PostMapping("/review/add") 
     public Review addReview(@RequestBody Review review) {
        String displayName = review.getDisplayName();
        if (displayName != null ){
            Optional<Person> personOptional = personRepository.findByDisplayName(displayName);
            if (!personOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This displayName is not valid");
            }
        }
        Long restaurantId = review.getRestaurantId();
        if (restaurantId != null ){
            Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
            if (!restaurantOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This restaurant id is not valid");
            }
        }
        Review newReview = reviewRepository.save(review);
        return newReview;
    }

    @GetMapping("/review/{id}")
    public List<Review> getReviewsByRestaurant(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This restaurant id is not valid"); 
        } else {
            List<Review> reviews = reviewRepository.findByRestaurantId(id);
            return reviews;
        }
    }

    @GetMapping("review/admin/{id}") 
    public List<Review> getReviewsForAdmin(@PathVariable Long id) {
         if (isAdmin(id)) {
            List<Review> pendingReviews = reviewRepository.findByStatus("PENDING");
            return pendingReviews;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This person is not an admin"); 
        }
    }

    @PutMapping("review/admin/{id}")
    public Review updateReviewStatus(@PathVariable Long id, @RequestBody Review review) {
        if (isAdmin(id)) {
            Optional<Review> reviewToUpdateOptional = reviewRepository.findById(review.getId());
            if (!reviewToUpdateOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "review is not available"); 
            } else {
                Review reviewToUpdate = reviewToUpdateOptional.get();
                reviewToUpdate.setStatus(review.getStatus());
                Review updatedReview = reviewRepository.save(reviewToUpdate);
                return updatedReview;
            }
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This person is not an admin"); 
        }
    }

    public Boolean isAdmin(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This person id is not valid"); 
        } else {
            Person person = personOptional.get();
            return person.getAdmin();
        }
    }
     
 
    
}
