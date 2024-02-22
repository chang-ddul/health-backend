package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dq_id")
    private DietQuestion dietQuestion;

    private String breakfast;

    private int breakfastCalorie;

    private String lunch;

    private int lunchCalorie;

    private String dinner;

    private int dinnerCalorie;

    private int sumOfCalorie;

    protected Diet(){}
    public static Diet createDiet(DietQuestion dietQuestion, String breakfast, int breakfastCalorie, String lunch, int lunchCalorie, String dinner, int dinnerCalorie, int sumOfCalorie) {
        Diet diet = new Diet();

        diet.dietQuestion = dietQuestion;
        diet.breakfast = breakfast;
        diet.breakfastCalorie = breakfastCalorie;
        diet.lunch = lunch;
        diet.lunchCalorie = lunchCalorie;
        diet.dinner = dinner;
        diet.dinnerCalorie = dinnerCalorie;
        diet.sumOfCalorie = sumOfCalorie;

        return diet;
    }
}
