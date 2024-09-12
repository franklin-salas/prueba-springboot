package com.digicert.prueba.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    @NotNull(message = "El nombre es obligatorio.")
    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(max = 255, message = "El nombre debe ser de máximo 255 caracteres.")
    private String name;
    @Size(max = 500, message = "La description debe ser de máximo 255 caracteres.")
    private String description;
    @NotNull(message = "La cantidad es obligatoria.")
    @Min(value = 0 , message = "el valor mínimo es 0.")
    private Double quantity;
    @NotNull(message = "El id de categoria es obligatorio.")
    private Long categoryId;
}
