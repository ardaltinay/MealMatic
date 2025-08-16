package com.ardaltinay.MealMatic.converter;

import com.ardaltinay.MealMatic.dto.CreateProductRequest;
import com.ardaltinay.MealMatic.dto.ProductDto;
import com.ardaltinay.MealMatic.dto.UpdateProductRequest;
import com.ardaltinay.MealMatic.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product toEntity(CreateProductRequest request) {
        return Product.builder()
                .category(request.category())
                .name(request.name())
                .price(request.price())
                .type(request.type())
                .description(request.description())
                .build();
    }

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId().toString())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .name(product.getName())
                .type(product.getType())
                .build();
    }

    public void convert(Product product, UpdateProductRequest request) {
        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setType(request.type());
        product.setDescription(request.description());
    }
}
