package com.example.ChatGPTwMicroservices.repositories;

import com.example.ChatGPTwMicroservices.models.Answers;

import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository {
    void save(Answers newAnswer);

}
