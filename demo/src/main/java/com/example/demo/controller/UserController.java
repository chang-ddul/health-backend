package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.user.CreateUserResponseDto;
import com.example.demo.dto.user.UserRequestDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public CreateUserResponseDto saveUser(@RequestBody UserRequestDto userRequestDto){
        User user = UserRequestDto.toEntity(userRequestDto);
        Long joinedUserId = userService.join(user);
        return new CreateUserResponseDto(joinedUserId);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("id") Long id) {
        userService.
    }
}
