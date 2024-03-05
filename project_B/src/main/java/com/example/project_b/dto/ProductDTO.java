package com.example.project_b.dto;


import com.example.project_b.domain.Product;

public record ProductDTO(
        Long id,
        String name,
        Double price
) {
    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product toProduct() {
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .build();
    }
}