package com.pedromolon.controledegastosapi.core.usecases;

import com.pedromolon.controledegastosapi.core.enums.TransactionType;
import com.pedromolon.controledegastosapi.core.gateway.TransactionGateway;
import com.pedromolon.controledegastosapi.core.model.Category;
import com.pedromolon.controledegastosapi.core.model.Transaction;
import com.pedromolon.controledegastosapi.core.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaveTransactionUseCase {

    private final TransactionGateway transactionGateway;

    public SaveTransactionUseCase(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public Transaction execute(String description, BigDecimal amount, TransactionType type, LocalDate date, Category category, User user) {
        Transaction transaction = new Transaction(description, amount, type, date, category, user);

        return transactionGateway.saveTransaction(transaction);
    }

}
