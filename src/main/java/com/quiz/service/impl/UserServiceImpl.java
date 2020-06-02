package com.quiz.service.impl;

import com.quiz.dto.UserDto;
import com.quiz.model.User;
import com.quiz.repository.UserRepository;
import com.quiz.service.UserService;
import com.quiz.util.GenericModelMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User createUser(UserDto userDto) {
        return userRepository.save(GenericModelMapper.convertToClass(userDto, User.class));
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        return userRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
