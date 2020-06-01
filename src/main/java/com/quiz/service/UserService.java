package com.quiz.service;

import com.quiz.model.User;
import java.util.List;

public interface UserService {

    void addUser(User user);

    User updateUser(Long id, User user);

    void removeUser(Long id);

    User getUser(Long id);

    List<User> getUsers();
}
