package com.digicert.prueba.dto.response;

import com.digicert.prueba.model.Category;
import com.digicert.prueba.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double quantity;
    private CategoryDto category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.category = new CategoryDto(product.getCategory());
    }
}
