package com.example.demo.dto.user;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Purpose;
import com.example.demo.domain.Sex;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {
    private String password;
    private String name;
    private Double height;
    private Double weight;
    private Sex sex;
    private Activity activity;
    private Purpose purpose;
    private Integer age;

}
