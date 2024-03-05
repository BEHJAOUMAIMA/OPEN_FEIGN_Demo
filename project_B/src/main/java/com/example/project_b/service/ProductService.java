package com.example.project_b.service;

import com.example.project_b.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);

}
