package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "이메일은 필수입니다")
    @Column(length = 30)
    private String username;

    @NotEmpty(message = "비밀번호는 필수입니다")
    private String password;

    @NotEmpty(message = "회원 이름은 필수입니다")
    @Column(length = 10)
    private String name;

    private Double height;

    private Double weight;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    private Integer age;

    private Integer bmr;

    private Integer am;



    protected User(){}

    public static User createUserInfo(String email, String password, String name, Double height, Double weight, Sex sex, Activity activity, Integer age, Purpose purpose) {
        User user = new User();

        user.username = email;
        user.password = password;
        user.name = name;
        user.height = height;
        user.weight = weight;
        user.age = age;
        user.sex = sex;
        user.activity = activity;
        user.purpose = purpose;

        Double calbmr = null;
        Double calam = null;
        if(user.sex == Sex.MALE) {
            calbmr = 66.47 + (13.75 * user.weight) + (5 * user.height) - (6.76 * user.age);
        }else{
            calbmr = 655.1 + (9.56 * user.weight) + (1.85 * user.height) - (4.68 * user.age);
        }

        switch(user.activity){
            case VERYSMALL -> calam = calbmr + calbmr * 0.2;
            case SMALL -> calam = calbmr + calbmr * 0.375;
            case NORMAL -> calam = calbmr + calbmr * 0.555;
            case BIG -> calam = calbmr + calbmr * 0.725;
            case VERYBIG -> calam = calbmr + calbmr * 0.9;
        }

        user.bmr = calbmr.intValue();

        switch(user.purpose){
            case LOSS -> calam -= 500;
            case MAINTAIN -> calam += 100;
            case GAIN -> calam += 500;
        }
        user.am = calam.intValue();

        return user;
    }

    public Long updateUserInfo(String password, String name, Double height, Double weight, Sex sex, Integer age, Activity activity, Purpose purpose){
        this.password = password;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.activity = activity;
        this.purpose = purpose;

        Double calbmr = null;
        Double calam = null;
        if(this.sex == Sex.MALE) {
            calbmr = 66.47 + (13.75 * this.weight) + (5 * this.height) - (6.76 * this.age);
        }else{
            calbmr = 655.1 + (9.56 * this.weight) + (1.85 * this.height) - (4.68 * this.age);
        }

        switch(this.activity){
            case VERYSMALL -> calam = calbmr + calbmr * 0.2;
            case SMALL -> calam = calbmr + calbmr * 0.375;
            case NORMAL -> calam = calbmr + calbmr * 0.555;
            case BIG -> calam = calbmr + calbmr * 0.725;
            case VERYBIG -> calam = calbmr + calbmr * 0.9;
        }

        this.bmr = calbmr.intValue();

        switch(this.purpose){
            case LOSS -> calam -= 500;
            case MAINTAIN -> calam += 100;
            case GAIN -> calam += 500;
        }

        this.am = calam.intValue();

        return this.id;

    }

}