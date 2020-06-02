package com.quiz.service;

import com.quiz.model.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    void removeUser(Long id);

    User getUser(Long id);

    List<User> getUsers();
}
