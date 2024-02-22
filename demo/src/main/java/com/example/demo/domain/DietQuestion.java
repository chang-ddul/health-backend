package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class DietQuestion {

    @Id
    @GeneratedValue
    @Column(name = "dq_date")
    private Long id;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected DietQuestion(){}

    public static DietQuestion createDietQuestion(LocalDate date, User user) {
        DietQuestion dietQuestion = new DietQuestion();

        dietQuestion.date = date;
        dietQuestion.user = user;

        return dietQuestion;
    }
}
