package com.digicert.prueba.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto {
    @NotNull(message = "El nombre es obligatorio.")
    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(max = 255, message = "El nombre debe ser de máximo 255 caracteres.")
    private String name;
    @Size(max = 500, message = "La description debe ser de máximo 255 caracteres.")
    private String description;
}
