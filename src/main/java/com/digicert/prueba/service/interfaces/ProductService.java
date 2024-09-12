package com.digicert.prueba.service.interfaces;

import com.digicert.prueba.dto.request.CategoryCreateDto;
import com.digicert.prueba.dto.request.CategoryUpdateDto;
import com.digicert.prueba.dto.request.ProductCreateDto;
import com.digicert.prueba.dto.request.ProductUpdateDto;
import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.dto.response.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductCreateDto productReq);
    ProductDto updateProduct(ProductUpdateDto productReq);
    ProductDto findProductById(Long id);
    List<ProductDto> searchProduct(String text);
    void deleteProductById(Long id);

}
