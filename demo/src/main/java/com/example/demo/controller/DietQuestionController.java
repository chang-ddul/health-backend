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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietQuestionController {
    private final UserService userService;
    private final DietQuestionService dietQuestionService;
    private final DietService dietService;

    @PostMapping("/users/{id}/diet")
    public DietQuestionResponseDto saveDietQuestion(@PathVariable("id") Long id){
        User user = userService.findOne(id);
        DietQuestion dietQuestion = DietQuestion.createDietQuestion(user);
        Diet diet = dietService.createGptResponse(dietQuestion);
        return new DietQuestionResponseDto(user, dietQuestion, diet);
    }

    @GetMapping("/users/{id}/diet")
    public List<DietQuestionResponseDto> getDietQuestionByUser(@PathVariable("id") Long id){
        User user = userService.findOne(id);
        List<DietQuestion> dietQuestionList = dietQuestionService.findByUserId(user.getId());
        List<Diet> dietList = null;
        for (DietQuestion dietQuestion: dietQuestionList) {
            dietList.add(dietService.findByDietQuestionId(dietQuestion.getId()));
        }

        List<DietQuestionResponseDto> dietQuestionResponseDtoList = null;
        for (int i = 0; i < dietQuestionList.size(); i++) {
            dietQuestionResponseDtoList.add(
                    new DietQuestionResponseDto(user, dietQuestionList.get(i), dietList.get(i))
            );
        }

        return dietQuestionResponseDtoList;
    }


}
