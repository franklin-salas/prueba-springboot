package com.digicert.prueba.repository;

import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.dto.response.ProductDto;
import com.digicert.prueba.model.Category;
import com.digicert.prueba.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {

//   List<Category> findByNameContaining(String name);

   @Query("SELECT p " +
           "FROM Product p " +
           "WHERE p.isDeleted = false AND p.id = :id  " )
   Optional<Product> findProductById (@Param("id")Long id);


   @Query("SELECT p " +
           "FROM Product p " +
           "JOIN FETCH p.category c "+
           "WHERE  p.isDeleted = false AND " +
           "(:text IS NULL OR UPPER(p.name) LIKE CONCAT('%', UPPER(:text), '%') OR UPPER(c.name) LIKE CONCAT('%', UPPER(:text), '%')) " +
           "ORDER BY p.id DESC")
   List<ProductDto> searchByNameAndCategoryName(@Param("text") String text);
}
