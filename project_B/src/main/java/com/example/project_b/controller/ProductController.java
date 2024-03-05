package com.example.project_b.controller;


import com.example.project_b.domain.Product;
import com.example.project_b.dto.ProductDTO;
import com.example.project_b.handler.response.ResponseMessage;
import com.example.project_b.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAll();
        if (products.isEmpty()) {
            return ResponseMessage.notFound("No product was found");
        }
        else{
            return ResponseMessage.ok("Products fetched successfully", products.stream().map(ProductDTO::fromProduct).toList());
        }
    }


}
