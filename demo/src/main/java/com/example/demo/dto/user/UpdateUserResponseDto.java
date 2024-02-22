package com.example.demo.dto.user;

import lombok.Getter;

@Getter
public class UpdateUserResponseDto {
    private Long id;

    public UpdateUserResponseDto(Long id) {
        this.id = id;
    }
}
