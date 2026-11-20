package com.pedromolon.controledegastosapi.core.usecases;

import com.pedromolon.controledegastosapi.core.enums.TransactionType;
import com.pedromolon.controledegastosapi.core.gateway.CategoryGateway;
import com.pedromolon.controledegastosapi.core.gateway.UserGateway;
import com.pedromolon.controledegastosapi.core.model.Category;
import com.pedromolon.controledegastosapi.core.model.User;

public class SaveCategoryUserCase {

    private final CategoryGateway categoryGateway;
    private final UserGateway userGateway;

    public SaveCategoryUserCase(CategoryGateway categoryGateway, UserGateway userGateway) {
        this.categoryGateway = categoryGateway;
        this.userGateway = userGateway;
    }

    public Category execute(String name, TransactionType type, Long userId) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        Category category;

        if (userId == null) {
            category = new Category(name, type, null);
        } else {
            if (!Boolean.TRUE.equals(userGateway.existsUserById(userId))) {
                throw new IllegalArgumentException("User does not exist");
            }
            User user = userGateway.getUserById(userId);
            category = new Category(name, type, user);
        }

        return categoryGateway.saveCategory(category);
    }

}
