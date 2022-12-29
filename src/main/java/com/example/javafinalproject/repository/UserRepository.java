package com.example.javafinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.javafinalproject.model.User;

public interface UserRepository extends CrudRepository <User, Long> {
    // TODO: create user with unique display name
    // TODO: update user profile except for name;
    // TODO: fetch user profile by name;
    // TODO: verify that the user exists, return optional? based on display name
}
