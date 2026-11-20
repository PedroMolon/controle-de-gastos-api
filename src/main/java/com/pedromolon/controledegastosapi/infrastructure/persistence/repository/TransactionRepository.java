package com.pedromolon.controledegastosapi.infrastructure.persistence.repository;

import com.pedromolon.controledegastosapi.infrastructure.persistence.model.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Boolean existsTransactionById(Long transactionId);
    Page<TransactionEntity> findAllTransactions(Pageable pageable);
}
