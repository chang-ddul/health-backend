package com.example.demo.controller;

import com.example.demo.domain.Diet;
import com.example.demo.domain.DietQuestion;
import com.example.demo.domain.User;
import com.example.demo.dto.dietQuestion.DietQuestionResponseDto;
import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.dto.user.CreateUserResponseDto;
import com.example.demo.service.DietQuestionService;
import com.example.demo.service.DietService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "식단")
@RestController
@RequiredArgsConstructor
public class DietQuestionController {
    private final UserService userService;
    private final DietQuestionService dietQuestionService;
    private final DietService dietService;

    @Operation(description = "유저 식단 생성")
    @PostMapping("/users/{id}/diet-questions")
    public DietQuestionResponseDto saveDietQuestion(@Parameter(description = "유저 id") @PathVariable("id") Long id){
        User user = userService.findOne(id);
        DietQuestion dietQuestion = DietQuestion.createDietQuestion(user);
        Diet diet = dietService.createGptResponse(dietQuestion);
        dietQuestionService.join(dietQuestion);
        dietService.join(diet);
        return new DietQuestionResponseDto(user, dietQuestion, diet);
    }

    @Operation(description = "유저 식단 가져오기")
    @GetMapping("/users/{id}/diet-questions")
    public List<DietQuestionResponseDto> getDietQuestionByUser(@Parameter(description = "유저 id") @PathVariable("id") Long id){
        User user = userService.findOne(id);
        List<DietQuestion> dietQuestionList = dietQuestionService.findByUserId(user.getId());
        List<Diet> dietList = new ArrayList<>();
        for (DietQuestion dietQuestion: dietQuestionList) {
            dietList.add(dietService.findByDietQuestionId(dietQuestion.getId()));
        }

        List<DietQuestionResponseDto> dietQuestionResponseDtoList = new ArrayList<>();
        for (int i = 0; i < dietQuestionList.size(); i++) {
            dietQuestionResponseDtoList.add(
                    new DietQuestionResponseDto(user, dietQuestionList.get(i), dietList.get(i))
            );
        }
        return dietQuestionResponseDtoList;
    }

    @Operation(description = "식단 삭제")
    @DeleteMapping("/diet-questions/{id}")
    public void deleteDietQuestion(@Parameter(description = "식단질문 id") @PathVariable("id") Long id){
        Diet diet = dietService.findByDietQuestionId(id);
        dietService.deleteDiet(diet.getId());
        dietQuestionService.deleteDietQuestion(id);
    }
}
