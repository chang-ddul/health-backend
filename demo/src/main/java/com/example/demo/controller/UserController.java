package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.user.*;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public CreateUserResponseDto saveUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        User user = CreateUserRequestDto.toEntity(createUserRequestDto);
        Long joinedUserId = userService.join(user);
        return new CreateUserResponseDto(joinedUserId);
    }

    @PutMapping("/users/{userId}")
    public UpdateUserResponseDto updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        User user = userService.findOne(id);

        userService.update(user,
                updateUserRequestDto.getPassword(), updateUserRequestDto.getName(), updateUserRequestDto.getHeight(),
                updateUserRequestDto.getWeight(), updateUserRequestDto.getSex(), updateUserRequestDto.getAge(),
                updateUserRequestDto.getActivity(), updateUserRequestDto.getObject());
        return new UpdateUserResponseDto(user.getId());
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/users/{userId}")
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return new UserResponseDto(userService.findOne(id));
    }

}
