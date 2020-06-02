package com.quiz.service.impl;

import com.quiz.model.User;
import com.quiz.repository.UserRepository;
import com.quiz.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
