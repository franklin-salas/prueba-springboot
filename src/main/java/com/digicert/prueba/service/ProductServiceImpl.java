package com.digicert.prueba.service;

import com.digicert.prueba.dto.request.ProductCreateDto;
import com.digicert.prueba.dto.request.ProductUpdateDto;
import com.digicert.prueba.dto.response.ProductDto;
import com.digicert.prueba.exception.ResourceNotFoundException;
import com.digicert.prueba.model.Category;
import com.digicert.prueba.model.Product;
import com.digicert.prueba.repository.CategoryRepository;
import com.digicert.prueba.repository.ProductRepository;
import com.digicert.prueba.service.interfaces.ProductService;
import com.digicert.prueba.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductDto createProduct(ProductCreateDto productReq) {

        Product product = new Product();
        product.setName(productReq.getName());
        product.setDescription(productReq.getDescription());
        product.setQuantity(productReq.getQuantity());

        Category category = categoryRepository.findCategoryById(productReq.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la categoria con id : " + productReq.getCategoryId()));
        product.setCategory(category);
        productRepository.save(product);

        ModelMapper mapper = new ModelMapper();

        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductUpdateDto productReq) {
        Product product = productRepository.findProductById( productReq.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con id : " + productReq.getId()));
        product.setName(productReq.getName());
        product.setDescription(productReq.getDescription());
        product.setQuantity(productReq.getQuantity());
        if(!product.getCategory().getId().equals(productReq.getCategoryId())){
            Category category = categoryRepository.findCategoryById(productReq.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontro la categoria con id : " + productReq.getCategoryId()));
            product.setCategory(category);
        }
        productRepository.save(product);

        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con id : " + id));
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> searchProduct(String text) {
        if(StringUtil.isEmptyOrNull(text)){
            text = null;
        }
        if(text != null){
            text =  text.trim();
        }
        return productRepository.searchByNameAndCategoryName(text);
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto con id : " + id));
        product.setIsDeleted(true);
        productRepository.save(product);

    }
}
