package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private final Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dq_id")
    private final DietQuestion dietQuestion;

    private final String breakfast;

    private final int breakfastCalorie;

    private final String lunch;

    private final int lunchCalorie;

    private final String dinner;

    private final int dinnerCalorie;

    private final int sumOfCalorie;

    public Diet(Long id, DietQuestion dietQuestion, String breakfast, int breakfastCalorie, String lunch, int lunchCalorie, String dinner, int dinnerCalorie, int sumOfCalorie) {
        this.id = id;
        this.dietQuestion = dietQuestion;
        this.breakfast = breakfast;
        this.breakfastCalorie = breakfastCalorie;
        this.lunch = lunch;
        this.lunchCalorie = lunchCalorie;
        this.dinner = dinner;
        this.dinnerCalorie = dinnerCalorie;
        this.sumOfCalorie = sumOfCalorie;
    }
}
