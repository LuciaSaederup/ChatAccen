package com.example.ChatGPTwMicroservices.repositories;

import com.example.ChatGPTwMicroservices.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository {
    void save(Answers newAnswer);

}
