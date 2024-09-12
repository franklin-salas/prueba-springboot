package com.digicert.prueba.service;

import com.digicert.prueba.dto.request.CategoryCreateDto;
import com.digicert.prueba.dto.request.CategoryUpdateDto;
import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.exception.ResourceNotFoundException;
import com.digicert.prueba.model.Category;
import com.digicert.prueba.repository.CategoryRepository;
import com.digicert.prueba.service.interfaces.CategoryService;
import com.digicert.prueba.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDto createCategory(CategoryCreateDto categoryReq) {

        ModelMapper mapper = new ModelMapper();
        Category category = new Category();

        category.setName(categoryReq.getName());
        category.setDescription(categoryReq.getDescription());

        categoryRepository.save(category);

        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryUpdateDto categoryReq) {
      Category category = categoryRepository.findCategoryById(categoryReq.getId())
              .orElseThrow(() -> new ResourceNotFoundException("No se encontro la categoria con id : " + categoryReq.getId()));
      category.setName(categoryReq.getName());
      category.setDescription(categoryReq.getDescription());
      ModelMapper mapper = new ModelMapper();
      categoryRepository.save(category);
      return mapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto findCategoryById(Long id) {
        Category category = categoryRepository.findCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la categoria con id : " + id));
        ModelMapper mapper = new ModelMapper();
        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> searchCategory(String text) {
        if(StringUtil.isEmptyOrNull(text)){
            text = null;
        }
        if(text != null){
            text =  text.trim();
        }
        return categoryRepository.searchByName(text);
    }

    @Override
    public void deleteCategoryById(Long id) {


        Category category = categoryRepository.findCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la categoria con id : " + id));
        category.setIsDeleted(true);
        categoryRepository.save(category);

    }
}
