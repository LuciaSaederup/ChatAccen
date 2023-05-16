package com.example.ChatGPTwMicroservices.repositories;

import com.example.ChatGPTwMicroservices.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface AnswerRepository extends JpaRepository<Answers, Long> {
    void save(Answers newAnswer);

}
