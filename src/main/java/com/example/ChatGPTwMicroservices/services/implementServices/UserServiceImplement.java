package com.example.ChatGPTwMicroservices.services.implementServices;

import com.example.ChatGPTwMicroservices.dtos.UserDTO;
import com.example.ChatGPTwMicroservices.models.User;
import com.example.ChatGPTwMicroservices.repositories.UserRepository;
import com.example.ChatGPTwMicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByEmail(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for email" + email);
        }
        return new User(user.getEmail(), user.getPassword(),
                user.getRoles());
    }


    @Override
    public UserDTO findByEmail(String email) {
        UserDTO userFind = new UserDTO(userRepository.findByEmail(email));
        return userFind;
    }


    @Override
    public UserDTO findById(Long id) {
        UserDTO userFind = new UserDTO(userRepository.findById(id));
        return userFind;
    }

    @Override
    public UserDTO getUser(Authentication authentication) {
        User user = this.userRepository.findByEmail(authentication.getName());
        return new UserDTO(user);
    }

    @Override

    public ResponseEntity<Object> createNewUser(User newUser) {
        userRepository.save(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
