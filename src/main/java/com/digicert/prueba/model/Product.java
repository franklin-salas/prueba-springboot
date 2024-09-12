package com.digicert.prueba.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "products")
@Entity
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends EntityModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "quantity" , nullable = false)
    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false, name = "category_id")
    private Category category;
}
