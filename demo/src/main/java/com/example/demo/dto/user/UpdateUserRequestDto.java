package com.example.demo.dto.user;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Object;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {
    private String password;
    private String name;
    private Double height;
    private Double weight;
    private Sex sex;
    private Activity activity;
    private Object object;
    private Integer age;

}
