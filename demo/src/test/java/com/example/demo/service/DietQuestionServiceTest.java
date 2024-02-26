package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.domain.Object;
import com.example.demo.repository.DietQuestionRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DietQuestionServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    DietQuestionService dietQuestionService;

    @Autowired
    DietQuestionRepository dietQuestionRepository;

    @Test
    @Transactional
    void join() {
        User user = User.createUserInfo("email@gmail.com", "pw", "name", 179D, 88D, Sex.MALE, Activity.BIG, 21, Object.MAINTAIN);
        Long joinedUser = userService.join(user);

        DietQuestion dietQuestion = DietQuestion.createDietQuestion(user);

        Long joinedDietQuestionId = dietQuestionService.join(dietQuestion);

        Optional<DietQuestion> byId = dietQuestionRepository.findById(joinedDietQuestionId);

        if(byId.isPresent()){
            org.assertj.core.api.Assertions.assertThat(byId.get().getId()).isEqualTo(1);
        }


    }

    @Test
    void createDiet() {


    }
}