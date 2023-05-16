package com.example.ChatGPTwMicroservices.dtos;

import com.example.ChatGPTwMicroservices.models.Answers;

public class AnswerDTO {
    private Long id;
    private String answer;

    public AnswerDTO(Answers answers) {
        this.id = answers.getId();
        this.answer = answers.getAnswer();
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
