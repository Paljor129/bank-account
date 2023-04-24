/*
package com.societegenerale.bankaccountsystem.infrastructure.mapper;

import com.societegenerale.bankaccountsystem.domain.model.Transaction;
import com.societegenerale.bankaccountsystem.domain.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionEntityMapper {

    private final ClientEntityMapper clientEntityMapper;

    public TransactionEntityMapper(ClientEntityMapper clientEntityMapper) {
        this.clientEntityMapper = clientEntityMapper;
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionEntity.getAmount());
        transaction.setTransactionDate(transactionEntity.getTransactionDate());
        transaction.setTransactionTypeCode(transactionEntity.getTransactionTypeCode());
        transaction.setServiceName(transactionEntity.getServiceName());
        transaction.setAmount(transactionEntity.getAmount());

        return transaction;
    };

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setTransactionDate(transaction.getTransactionDate());
        transactionEntity.setTransactionTypeCode(transaction.getTransactionTypeCode());
        transactionEntity.setServiceName(transaction.getServiceName());
        transactionEntity.setAmount(transaction.getAmount());

        return transactionEntity;
    };

    public List<Transaction> toTransactions(List<TransactionEntity> transactionEntities) {
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionEntities) {
            transactions.add(this.toTransaction(transactionEntity));
        }
        return transactions;
    }

    public List<TransactionEntity> toTransactionEntities(List<Transaction> transactions) {
        List<TransactionEntity> transactionEntities = new ArrayList<>();
        for (Transaction transaction : transactions) {
            transactionEntities.add(this.toTransactionEntity(transaction));
        }
        return transactionEntities;
    }

}
*/
