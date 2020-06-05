package com.quiz.controller;

import com.quiz.dto.ListForDto;
import com.quiz.dto.UserDto;
import com.quiz.service.UserService;
import com.quiz.util.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return GenericModelMapper.convertToClass(userService.createUser(userDto), UserDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {
        return GenericModelMapper.convertToClass(userService.getUser(id), UserDto.class);
    }

    @GetMapping("/all")
    public ListForDto<UserDto> getAllUsers() {
        return GenericModelMapper.convertList(new ListForDto<>(userService.getUsers()), UserDto.class);
    }
}
