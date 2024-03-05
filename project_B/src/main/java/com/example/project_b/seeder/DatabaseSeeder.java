package com.example.project_b.seeder;


import com.example.project_b.domain.Product;
import com.example.project_b.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args) {
        productRepository.deleteAll();

        List<Product> products  = Arrays.asList(
                Product.builder().name("Product 1").price(10.99).build(),
                Product.builder().name("Product 2").price(20.49).build(),
                Product.builder().name("Product 3").price(15.75).build()
        );

        productRepository.saveAll(products);
    }
}
