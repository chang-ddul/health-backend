package com.example.demo.dto.user;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Purpose;
import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;
    private Double height;
    private Double weight;
    private Sex sex;
    private Activity activity;
    private Purpose purpose;
    private Integer age;
    private Integer bmr;
    private Integer am;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getUsername();
        this.name = user.getName();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.sex = user.getSex();
        this.activity = user.getActivity();
        this.purpose = user.getPurpose();
        this.age = user.getAge();
        this.bmr = user.getBmr();
        this.am = user.getAm();
    }
}
