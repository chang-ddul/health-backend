package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.user.*;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "유저 등록")
    @PostMapping("/users")
    public CreateUserResponseDto saveUser(@Parameter(description = "등록할 유저 정보") @RequestBody CreateUserRequestDto createUserRequestDto){
        User user = CreateUserRequestDto.toEntity(createUserRequestDto);
        Long joinedUserId = userService.join(user);
        return new CreateUserResponseDto(joinedUserId);
    }

    @Operation(summary = "유저 정보 수정")
    @PutMapping("/users/{id}")
    public UpdateUserResponseDto updateUser(@Parameter(description = "유저 id") @PathVariable("id") Long id, @Parameter(description = "수정할 유저 정보")@RequestBody UpdateUserRequestDto updateUserRequestDto) {
        User user = userService.findOne(id);

        userService.update(user,
                updateUserRequestDto.getPassword(), updateUserRequestDto.getName(), updateUserRequestDto.getHeight(),
                updateUserRequestDto.getWeight(), updateUserRequestDto.getSex(), updateUserRequestDto.getAge(),
                updateUserRequestDto.getActivity(), updateUserRequestDto.getPurpose());
        return new UpdateUserResponseDto(user.getId());
    }

    @Operation(summary = "유저 삭제")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@Parameter(description = "유저 id") @PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @Operation(summary = "유저 정보 조회")
    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@Parameter(description = "유저 id") @PathVariable("id") Long id) {
        return new UserResponseDto(userService.findOne(id));
    }

}
