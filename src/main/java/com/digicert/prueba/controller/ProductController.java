package com.digicert.prueba.controller;

import com.digicert.prueba.dto.request.CategoryCreateDto;
import com.digicert.prueba.dto.request.CategoryUpdateDto;
import com.digicert.prueba.dto.request.ProductCreateDto;
import com.digicert.prueba.dto.request.ProductUpdateDto;
import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.dto.response.ProductDto;
import com.digicert.prueba.service.interfaces.CategoryService;
import com.digicert.prueba.service.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductCreateDto product) {
        return  productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id ) {
        return  productService.findProductById(id);
    }

    @PutMapping
    public ProductDto updateProduct(@Valid @RequestBody ProductUpdateDto product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProduct(@RequestParam(value = "q",required = false, defaultValue = "") String query) {
        return  productService.searchProduct(query);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") Long id ) {
        HttpStatus status = HttpStatus.OK;
        productService.deleteProductById(id);
        return new ResponseEntity<>(status);
    }
}
