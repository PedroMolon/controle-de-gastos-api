package com.pedromolon.controledegastosapi.core.gateway;

import com.pedromolon.controledegastosapi.core.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionGateway {
    Transaction saveTransaction(Transaction transaction);
    Transaction getTransactionById(Long transactionId);
    Transaction updateTransactionById(Long transactionId);
    Transaction deleteTransactionById(Long transactionId);
    Boolean existsTransactionById(Long transactionId);
    Page<Transaction> findAllTransactions(Pageable pageable);
}
