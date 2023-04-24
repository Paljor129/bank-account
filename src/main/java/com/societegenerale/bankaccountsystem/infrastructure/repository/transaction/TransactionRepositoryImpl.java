package com.societegenerale.bankaccountsystem.infrastructure.repository.transaction;

import com.societegenerale.bankaccountsystem.domain.entity.Transaction;
import com.societegenerale.bankaccountsystem.domain.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRepositoryImpl.class);

    private final TransactionJpaRepository transactionJpaRepository;

    public TransactionRepositoryImpl(TransactionJpaRepository transactionJpaRepository) {
        this.transactionJpaRepository = transactionJpaRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        LOGGER.debug("transaction save - {}", transaction);
        return transactionJpaRepository.save(transaction);
    }
}
