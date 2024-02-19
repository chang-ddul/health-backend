package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "비밀번호는 필수입니다")
    private String password;

    @NotEmpty(message = "회원 이름은 필수입니다")
    private String name;

    private Double height;

    private Double weight;

    private Integer age;

    private Integer bmr;

    private Integer am;


    public User createUserInfo(String password, String name, double height, double weight, int age, int bmr, int am) {
        User user = new User();

        user.password = password;
        user.name = name;
        user.height = height;
        user.weight = weight;
        user.age = age;
        user.bmr = bmr;
        user.am = am;

        return user;
    }



}
