package com.example.demo.dto.dietQuestion;

import com.example.demo.domain.Diet;
import com.example.demo.domain.DietQuestion;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
public class DietResponseDto {
    private Long id;
    private String breakfast;
    private int breakfastCalorie;
    private String lunch;
    private int lunchCalorie;
    private String dinner;
    private int dinnerCalorie;
    private int sumOfCalorie;

    public DietResponseDto(Diet diet) {
        this.id = diet.getId();
        this.breakfast = diet.getBreakfast();
        this.breakfastCalorie = diet.getBreakfastCalorie();
        this.lunch = diet.getLunch();
        this.lunchCalorie = diet.getLunchCalorie();
        this.dinner = diet.getDinner();
        this.dinnerCalorie = diet.getDinnerCalorie();
        this.sumOfCalorie = diet.getSumOfCalorie();
    }
}
