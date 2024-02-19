package com.example.demo.service;

import com.example.demo.domain.Activity;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user){
        User member = userRepository.save(user);

        return member.getId();
    }

    @Transactional
    public Long update(User user,Double height, Double weight, Integer age, Activity activity){
        user.updateUserInfo(height, weight, age, activity);
        userRepository.save(user);

        return user.getId();
    }
}
