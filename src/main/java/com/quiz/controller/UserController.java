package com.quiz.controller;

import com.quiz.dto.ListForDto;
import com.quiz.dto.UserDto;
import com.quiz.service.impl.UserServiceImpl;
import com.quiz.util.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return GenericModelMapper.convertToClass(userService.createUser(userDto), UserDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUser(id);
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
