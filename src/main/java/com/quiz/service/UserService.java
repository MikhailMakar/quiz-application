package com.quiz.service;

import com.quiz.model.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    void deleteById(long id);

    User getUserById(long id);

    List<User> getUsers();
}
