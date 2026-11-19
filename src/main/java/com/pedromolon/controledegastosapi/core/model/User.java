package com.pedromolon.controledegastosapi.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class User {

    private Long id;
    private final String name;
    private final String email;
    private final String password;
    private BigDecimal balance;
    private final LocalDateTime createdAt;

    // Construtor padrão
    public User(Long id, String name, String email, String password, BigDecimal balance, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    // Construtor para NOVO usuário
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
    }

    public void credit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount for credit operation");
        }
        this.balance = this.balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount for debit operation");
        }
        if (amount.compareTo(this.balance) > 0) {
            throw new IllegalArgumentException("Insufficient balance for debit operation");
        }
        this.balance = this.balance.subtract(amount);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
