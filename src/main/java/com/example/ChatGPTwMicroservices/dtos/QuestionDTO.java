package com.example.ChatGPTwMicroservices.dtos;

public class QuestionDTO {
    private Long id;
    private String question;
    private  double price;

    public QuestionDTO(QuestionDTO questionDTO){
        this.id = questionDTO.getId();
        this.price = 10.00;
        this.question = questionDTO.getQuestion();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
