package com.example.ChatGPTwMicroservices.repositories;

import com.example.ChatGPTwMicroservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void save(User newUser);

}

