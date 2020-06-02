package com.quiz.service;

import com.quiz.dto.UserDto;
import com.quiz.model.User;
import java.util.List;

public interface UserService {

    User createUser(UserDto userDto);

    void deleteUser(long id);

    User getUser(long id);

    List<User> getUsers();
}
