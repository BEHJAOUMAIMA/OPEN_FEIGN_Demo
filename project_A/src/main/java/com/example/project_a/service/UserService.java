package com.example.project_a.service;

import com.example.project_a.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAll();
    Optional<User> getById(Long id);

}
