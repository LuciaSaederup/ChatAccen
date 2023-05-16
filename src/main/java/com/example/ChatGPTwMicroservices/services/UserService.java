package com.example.ChatGPTwMicroservices.services;

import com.example.ChatGPTwMicroservices.dtos.UserDTO;
import com.example.ChatGPTwMicroservices.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO getUser(Authentication authentication);
    UserDTO getUserByEmail(String email);

    ResponseEntity<Object> createNewUser(User newUser);

    UserDTO findByEmail(String email);
}
