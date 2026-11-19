package com.pedromolon.controledegastosapi.core.gateway;

import com.pedromolon.controledegastosapi.core.model.User;

public interface UserGateway {
    User saveUser(User user);
    User getUserById(Long userId);
    User updateUserById(Long userId);
    User deleteUserById(Long userId);
    User getUserByEmail(String email);
    Boolean existsUserByEmail(String email);
    Boolean existsUserById(Long userId);
}
