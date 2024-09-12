package com.digicert.prueba.repository;

import com.digicert.prueba.dto.response.CategoryDto;
import com.digicert.prueba.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category,Long> {

//   List<Category> findByNameContaining(String name);
@Query("SELECT c " +
        "FROM Category c " +
        "WHERE c.isDeleted = false AND c.id = :id  " )
  Optional<Category> findCategoryById (@Param("id")Long id);

   @Query("SELECT c " +
           "FROM Category c " +
           "WHERE  c.isDeleted = false AND " +
           "(:text IS NULL OR UPPER(c.name) LIKE CONCAT('%', UPPER(:text), '%')) " +
           "ORDER BY c.id DESC ")
   List<CategoryDto> searchByName(@Param("text") String text);
}
