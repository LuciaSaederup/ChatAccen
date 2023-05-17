package com.example.ChatGPTwMicroservices.repositories;

import com.example.ChatGPTwMicroservices.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void save(User newUser);

}

