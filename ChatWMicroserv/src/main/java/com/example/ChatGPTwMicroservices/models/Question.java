package com.example.ChatGPTwMicroservices.models;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
    public class Question {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")

        private Long id;
        private String question;
        private double price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name= "answer_id")
    private Answers answer;

        public Question() {
        }

        public Question(String question, User user) {
            this.question = question;
            this.price =10.00;
            this.user = user;

        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question=" + question +
                ", price=" + price +
                ", answer=" + answer +
                ", user=" + user +
                '}';
    }

}
