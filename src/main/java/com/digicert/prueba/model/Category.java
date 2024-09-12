package com.digicert.prueba.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "categories")
@Entity
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category extends EntityModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

}
