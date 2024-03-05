package com.example.project_a.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-service", url = "http://127.0.0.1:8081/api/v1/products")
public interface ProductProxy {

    @GetMapping
    ResponseEntity<?> getAllProducts();

}
