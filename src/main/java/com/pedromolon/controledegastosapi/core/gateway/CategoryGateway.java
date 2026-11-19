package com.pedromolon.controledegastosapi.core.gateway;

import com.pedromolon.controledegastosapi.core.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryGateway {
    Category saveCategory(Category category);
    Category getCategoryById(Long categoryId);
    Category updateCategoryById(Category category);
    Category deleteCategoryById(Long categoryId);
    Page<Category> findAllCategories(Pageable pageable);
    Boolean existsCategoryById(Long categoryId);
}
