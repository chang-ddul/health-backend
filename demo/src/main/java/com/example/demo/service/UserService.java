package com.example.demo.service;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Purpose;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public Long join(User user){
        Boolean isExist = userRepository.existsByUsername(user.getUsername());

        if(isExist){
            throw new CustomException("이미 존재하는 이메일 입니다.");
        }
        Long updateId = this.update(user, bCryptPasswordEncoder.encode(user.getPassword()), user.getName(), user.getHeight(), user.getWeight(), user.getSex(), user.getAge(), user.getActivity(), user.getPurpose());

        return updateId;
    }

    @Transactional
    public Long update(User user, String password, String name, Double height, Double weight, Sex sex, Integer age, Activity activity, Purpose purpose){
        user.updateUserInfo(password, name, height, weight, sex, age, activity, purpose);
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
