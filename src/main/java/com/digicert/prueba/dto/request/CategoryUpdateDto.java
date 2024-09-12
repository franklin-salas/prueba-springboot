package com.digicert.prueba.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDto {

    @NotNull(message = "El id es obligatorio.")
    private Long id;
    @NotNull(message = "El nombre es obligatorio.")
    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(max = 255, message = "El nombre debe ser de máximo 255 caracteres.")
    private String name;
    @Size(max = 500,message = "La descripcion debe ser de máximo 500 caracteres.")
    private String description;
}
