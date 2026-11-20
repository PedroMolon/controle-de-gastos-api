package com.pedromolon.controledegastosapi.core.usecases;

import com.pedromolon.controledegastosapi.core.enums.TransactionType;
import com.pedromolon.controledegastosapi.core.gateway.CategoryGateway;
import com.pedromolon.controledegastosapi.core.gateway.TransactionGateway;
import com.pedromolon.controledegastosapi.core.gateway.UserGateway;
import com.pedromolon.controledegastosapi.core.model.Category;
import com.pedromolon.controledegastosapi.core.model.Transaction;
import com.pedromolon.controledegastosapi.core.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaveTransactionUseCase {

    private final TransactionGateway transactionGateway;
    private final CategoryGateway categoryGateway;
    private final UserGateway userGateway;

    public SaveTransactionUseCase(TransactionGateway transactionGateway, CategoryGateway categoryGateway, UserGateway userGateway) {
        this.transactionGateway = transactionGateway;
        this.categoryGateway = categoryGateway;
        this.userGateway = userGateway;
    }

    public Transaction execute(String description, BigDecimal amount, TransactionType type, LocalDate date, Long categoryId, Long userId) {
        Category category = categoryGateway.getCategoryById(categoryId);

        User user = userGateway.getUserById(userId);

        Transaction transaction = new Transaction(description, amount, type, date, category, user);

        if (user != null) {
            if (type == TransactionType.EXPENSE) {
                user.debit(amount);
            } else if (type == TransactionType.INCOME){
                user.credit(amount);
            }
            userGateway.saveUser(user);
        }

        return transactionGateway.saveTransaction(transaction);
    }

}
