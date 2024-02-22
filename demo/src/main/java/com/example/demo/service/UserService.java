package com.example.demo.service;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Object;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Long update(User user, String password, String name, Double height, Double weight, Sex sex, Integer age, Activity activity, Object object){
        user.updateUserInfo(password, name, height, weight, sex, age, activity, object);
        userRepository.save(user);

        return user.getId();
    }

    @Transactional
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public User findOne(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new CustomException("존재하지 않는 유저");
        }
        return user.get();
    }


}
