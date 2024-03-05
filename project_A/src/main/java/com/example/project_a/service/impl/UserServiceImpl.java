package com.example.project_a.service.impl;

import com.example.project_a.domain.User;
import com.example.project_a.handler.exception.OperationException;
import com.example.project_a.repository.UserRepository;
import com.example.project_a.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new OperationException("No users found ! ");
        }
        return users;
    }

    @Override
    public Optional<User> getById(Long id) {
        if (id <= 0) {
            throw new OperationException("ID must be greater than 0");
        }
        return userRepository.findById(id);
    }
}
