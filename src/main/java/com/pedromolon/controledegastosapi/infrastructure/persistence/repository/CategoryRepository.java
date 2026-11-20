package com.pedromolon.controledegastosapi.infrastructure.persistence.repository;

import com.pedromolon.controledegastosapi.infrastructure.persistence.model.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Page<CategoryEntity> findAllCategories(Pageable pageable);
    Boolean existsCategoryById(Long categoryId);
}
