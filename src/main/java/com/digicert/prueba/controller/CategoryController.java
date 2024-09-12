package com.digicert.prueba.controller;

import com.digicert.prueba.dto.request.CategoryCreateDto;
import com.digicert.prueba.dto.request.CategoryUpdateDto;
import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@Validated
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryDto createCategory( @Valid @RequestBody  CategoryCreateDto category) {
     return  categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Long id ) {
      return  categoryService.findCategoryById(id);
    }

    @PutMapping
    public CategoryDto updateCategory(@Valid @RequestBody  CategoryUpdateDto category) {
        return categoryService.updateCategory(category);
    }

    @GetMapping("/search")
    public List<CategoryDto> searchCategory(@RequestParam(value = "q",required = false, defaultValue = "") String query) {
        return  categoryService.searchCategory(query);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("id") Long id ) {
        HttpStatus status = HttpStatus.OK;
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(status);
    }
}
