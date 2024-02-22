package com.example.demo.dto.user;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Object;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String email;
    private String password;
    private String name;
    private Double height;
    private Double weight;
    private Sex sex;
    private Activity activity;
    private Object object;
    private Integer age;

//    @Builder
//    public UserRequestDto(String email, String password, String name, Double height, Double weight, Sex sex, Activity activity, Object object, Integer age) {
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.height = height;
//        this.weight = weight;
//        this.sex = sex;
//        this.activity = activity;
//        this.object = object;
//        this.age = age;
//    }

    public static User toEntity(UserRequestDto userRequestDto) {
        return User.createUserInfo(
                userRequestDto.getEmail(), userRequestDto.getPassword(), userRequestDto.getName(),
                userRequestDto.getHeight(), userRequestDto.getWeight(), userRequestDto.getSex(),
                userRequestDto.getActivity(), userRequestDto.getAge(), userRequestDto.getObject()
        );
    }
}
