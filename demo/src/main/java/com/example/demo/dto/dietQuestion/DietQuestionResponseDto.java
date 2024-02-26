package com.example.demo.dto.dietQuestion;

import com.example.demo.domain.*;
import com.example.demo.domain.Object;
import com.example.demo.dto.user.UserResponseDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DietQuestionResponseDto {
    private Long userId;
    private Long id;
    private LocalDate date;
    private DietResponseDto dietResponseDto;

    public DietQuestionResponseDto(User user, DietQuestion dietQuestion, Diet diet) {
        this.userId = user.getId();
        this.id = dietQuestion.getId();
        this.date = dietQuestion.getDate();
        this.dietResponseDto = new DietResponseDto(diet);
    }
}
