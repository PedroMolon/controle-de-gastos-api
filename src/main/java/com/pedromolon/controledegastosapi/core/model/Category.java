package com.pedromolon.controledegastosapi.core.model;

import com.pedromolon.controledegastosapi.core.enums.TransactionType;

public class Category {

    private Long id;
    private final String name;
    private final TransactionType type;
    private final User user;

    // Construtor padrão
    public Category(Long id, String name, TransactionType type, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user = user;
    }

    // Construtor para nova categoria
    public Category(String name, TransactionType type, User user) {
        this.name = name;
        this.type = type;
        this.user = user;
    }

    // Construtor para nova categoria global
    public Category(String name, TransactionType type) {
        this.name = name;
        this.type = type;
        this.user = null;
    }

    public boolean isGlobal() {
        return this.user == null;
    }

    public boolean belongsToUser(Long userId) {
        if (isGlobal()) return false;
        return this.user.getId().equals(userId);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }
}
