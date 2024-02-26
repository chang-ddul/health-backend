package com.example.demo.chatgpt;

import com.example.demo.domain.*;
import com.example.demo.domain.Purpose;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DietQuestionService;
import com.example.demo.service.DietService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatgptApiTestTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DietQuestionService dietQuestionService;

    @Autowired
    DietService dietService;

    @Test
    void generateDiet() {
        User user = User.createUserInfo("email@gmail.com", "pw", "name", 179D, 88D, Sex.MALE, Activity.BIG, 21, Purpose.MAINTAIN);

        DietQuestion dietQuestion = DietQuestion.createDietQuestion(user);

        Diet gptResponse = dietService.createGptResponse(dietQuestion);

        System.out.println("gptResponse.breakfast = " + gptResponse.getBreakfast());
        System.out.println("gptResponse.lunch = " + gptResponse.getLunch());
        System.out.println("gptResponse.lunch = " + gptResponse.getDinner());
        System.out.println("gptResponse.bKcal = " + gptResponse.getBreakfastCalorie());
        System.out.println("gptResponse.lkcal = " + gptResponse.getLunchCalorie());
        System.out.println("gptResponse.dkcal = " + gptResponse.getDinnerCalorie());
        System.out.println("gptResponse.getSumOfCalorie() = " + gptResponse.getSumOfCalorie());
    }
}