package com.digicert.prueba.service.interfaces;

import com.digicert.prueba.dto.request.CategoryCreateDto;
import com.digicert.prueba.dto.request.CategoryUpdateDto;
import com.digicert.prueba.dto.response.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryCreateDto categoryReq);
    CategoryDto updateCategory(CategoryUpdateDto categoryReq);
    CategoryDto findCategoryById(Long id);
    List<CategoryDto> searchCategory(String text);
    void deleteCategoryById(Long id);

}
