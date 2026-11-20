package com.pedromolon.controledegastosapi.core.model;

import com.pedromolon.controledegastosapi.core.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private final String description;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDate date;
    private final Category category;
    private final User user;
    private final LocalDateTime createdAt;

    public Transaction(Long id, String description, BigDecimal amount, TransactionType type, LocalDate date, Category category, User user, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.category = category;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Transaction(String description, BigDecimal amount, TransactionType type, LocalDate date, Category category, User user) {
        validate(amount, type, date, category, user);
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date != null ? date : LocalDate.now();
        this.category = category;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    private void validate(BigDecimal amount, TransactionType type, LocalDate date, Category category, User user) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Transaction type is required.");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category is required.");
        }
        if (user == null) {
            throw new IllegalArgumentException("User is required.");
        }
        if (!category.getType().equals(type)) {
            throw new IllegalArgumentException("Transaction type does not match the selected category type.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
