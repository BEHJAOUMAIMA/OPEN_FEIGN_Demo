package com.example.project_a.dto;

import com.example.project_a.domain.User;

public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email
) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }

    public User toUser() {
        return User.builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .build();
    }
}