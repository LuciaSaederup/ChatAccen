package com.example.ChatGPTwMicroservices.controllers;

import com.example.ChatGPTwMicroservices.dtos.UserDTO;
import com.example.ChatGPTwMicroservices.models.User;
import com.example.ChatGPTwMicroservices.repositories.QuestionRepository;
import com.example.ChatGPTwMicroservices.repositories.UserRepository;
import com.example.ChatGPTwMicroservices.services.QuestionService;
import com.example.ChatGPTwMicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionRepository questionRepository;

    //Authentication
    @GetMapping("/current")
    public UserDTO getUser(Authentication authentication){
        return userService.getUser(authentication);
    }
    @Autowired

    private PasswordEncoder passwordEncoder;
    @PostMapping(path = "/question")

    public ResponseEntity<Object> createQuestion(

            @RequestParam String firstName, @RequestParam String lastName,

            @RequestParam String email, @RequestParam String password) throws IOException {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (userService.findByEmail(email) !=  null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }

        User newUser=new User(firstName, lastName, email, passwordEncoder.encode(password));

        return userService.createNewUser(newUser);

    }


}
