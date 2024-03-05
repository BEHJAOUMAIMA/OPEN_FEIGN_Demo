package com.example.project_a.controller;

import com.example.project_a.domain.User;
import com.example.project_a.dto.UserDTO;
import com.example.project_a.handler.response.ResponseMessage;
import com.example.project_a.service.ProductProxy;
import com.example.project_a.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ProductProxy productProxy;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return ResponseMessage.notFound("No user was found");
        }
        else{
            return ResponseMessage.ok("Users fetched successfully", users.stream().map(UserDTO::fromUser).toList());
        }
    }

    @GetMapping("/getProducts")
    public ResponseEntity<?> getAllProducts(){
        return productProxy.getAllProducts();

    }

}
