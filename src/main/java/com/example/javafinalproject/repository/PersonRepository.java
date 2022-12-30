package com.example.javafinalproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.Person;

public interface PersonRepository extends CrudRepository <Person, Long> {
    Optional<Person> findById(Long id);
    Optional<Person> findByDisplayName(String displayName);
}
