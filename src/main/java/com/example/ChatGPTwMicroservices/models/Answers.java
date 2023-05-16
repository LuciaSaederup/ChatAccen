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

    private double price;


    public Answers() {
    }

    public Answers(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @OneToMany(mappedBy="answers", fetch= FetchType.EAGER)
    Set<Question> questions = new HashSet<>();
    public Set<Question> getQuestions() {
        return questions;
    }


}
