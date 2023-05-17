package com.example.ChatGPTwMicroservices.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;
    private String answer;


    public Answers() {
    }

    public Answers(String answer) {
        this.answer = answer;
    }


    @OneToMany(mappedBy="answers", fetch= FetchType.EAGER)
    Set<Question> questions = new HashSet<>();
    public Set<Question> getQuestions() {
        return questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



}
