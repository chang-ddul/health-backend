package com.example.demo.domain;

import com.example.demo.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Length;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "메세지는 필수입니다")
    @Column(length = 30)
    private String email;

    @NotEmpty(message = "비밀번호는 필수입니다")
    @Column(length = 20)
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

    private Integer age;

    private Integer bmr;

    private Integer am;


    protected User(){}
    public static User createUserInfo(String password, String name, Double height, Double weight, Sex sex, Activity activity, Integer age) {
        User user = new User();

        user.password = password;
        user.name = name;
        user.height = height;
        user.weight = weight;
        user.age = age;
        user.sex = sex;
        user.activity = activity;

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
        user.am = calam.intValue();

        return user;
    }

    public Long updateUserInfo(Double height, Double weight, Integer age, Activity activity){
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.activity = activity;

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
        this.am = calam.intValue();

        return this.id;

    }

}
