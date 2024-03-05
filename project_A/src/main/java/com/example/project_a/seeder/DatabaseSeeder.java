package com.example.project_a.seeder;

import com.example.project_a.domain.User;
import com.example.project_a.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {
        userRepository.deleteAll();

        List<User> users = Arrays.asList(
                User.builder().firstname("John").lastname("Doe").email("john@example.com").build(),
                User.builder().firstname("Alice").lastname("Smith").email("alice@example.com").build(),
                User.builder().firstname("Bob").lastname("Johnson").email("bob@example.com").build()
        );

        userRepository.saveAll(users);
    }
}
