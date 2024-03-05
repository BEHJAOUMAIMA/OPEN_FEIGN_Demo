package com.example.project_b.service.impl;

import com.example.project_b.domain.Product;
import com.example.project_b.handler.exception.OperationException;
import com.example.project_b.repository.ProductRepository;
import com.example.project_b.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        List<Product> users = productRepository.findAll();
        if (users.isEmpty()) {
            throw new OperationException("No products found ! ");
        }
        return users;
    }

    @Override
    public Optional<Product> getById(Long id) {
        if (id <= 0) {
            throw new OperationException("ID must be greater than 0");
        }
        return productRepository.findById(id);
    }
}
