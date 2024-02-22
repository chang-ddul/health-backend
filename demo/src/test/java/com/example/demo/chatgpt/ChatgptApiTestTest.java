package com.example.demo.chatgpt;

import com.example.demo.domain.*;
import com.example.demo.domain.Object;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DietQuestionService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatgptApiTestTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DietQuestionService dietQuestionService;

    @Test
    void generateDiet() {
        User user = User.createUserInfo("email@gmail.com", "pw", "name", 179D, 88D, Sex.MALE, Activity.BIG, 21, Object.MAINTAIN);

        DietQuestion dietQuestion = DietQuestion.createDietQuestion(LocalDate.now(), user);
        String s = dietQuestionService.createDiet(dietQuestion);
        System.out.println(s);
    }
}