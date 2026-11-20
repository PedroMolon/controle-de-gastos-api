package com.pedromolon.controledegastosapi.core.usecases;

import com.pedromolon.controledegastosapi.core.gateway.UserGateway;
import com.pedromolon.controledegastosapi.core.model.User;

public class  SaveUserUseCase {

    private final UserGateway userGateway;

    public SaveUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(String name, String email, String password) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }

        if (Boolean.TRUE.equals(userGateway.existsUserByEmail(email))) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }

        User user = new User(name, email, password);

        return userGateway.saveUser(user);
    }

}
