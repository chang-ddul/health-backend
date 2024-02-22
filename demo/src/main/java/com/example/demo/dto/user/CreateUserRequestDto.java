package com.example.demo.dto.user;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Object;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private String email;
    private String password;
    private String name;
    private Double height;
    private Double weight;
    private Sex sex;
    private Activity activity;
    private Object object;
    private Integer age;

    public static User toEntity(CreateUserRequestDto userRequestDto) {
        return User.createUserInfo(
                userRequestDto.getEmail(), userRequestDto.getPassword(), userRequestDto.getName(),
                userRequestDto.getHeight(), userRequestDto.getWeight(), userRequestDto.getSex(),
                userRequestDto.getActivity(), userRequestDto.getAge(), userRequestDto.getObject()
        );
    }
}