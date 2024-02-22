package com.example.demo.dto.user;

import lombok.Getter;

@Getter
public class CreateUserResponseDto {
    private Long id;

    public CreateUserResponseDto(Long id) {
        this.id = id;
    }


}
