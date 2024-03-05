package com.example.project_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectAApplication.class, args);
    }

}
