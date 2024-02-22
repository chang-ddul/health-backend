package com.example.demo.service;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Object;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void update() {

        User user = User.createUserInfo("조성우", "성우","조성우",180.0, 70.0, Sex.MALE, Activity.BIG
        , 21, Object.GAIN);

        Long joinedUserId = userService.join(user);

        Long updateId = userService.update(user, 150.0, 15.0, 54, Activity.BIG);

        Optional<User> findUser1 = userRepository.findById(updateId);

        if(findUser1.isPresent()){
            Assertions.assertThat(findUser1.get().getHeight()).isEqualTo(150.0);
        }



    }
}