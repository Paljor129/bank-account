package com.societegenerale.bankaccountsystem.controller.mapper;

import com.societegenerale.bankaccountsystem.controller.dto.TransactionDto;
import com.societegenerale.bankaccountsystem.domain.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionMapper {

    public TransactionDto mapToDto(Transaction entity) {
        TransactionDto dto = new TransactionDto();
        dto.setAmount(entity.getAmount());
        dto.setTransactionDate(entity.getTransactionDate());
        dto.setTransactionTypeCode(entity.getTransactionTypeCode());
        dto.setServiceName(entity.getServiceName());

        return dto;
    }

    public Transaction mapToEntity(TransactionDto dto) {
        Transaction entity = new Transaction();
        entity.setAmount(dto.getAmount());
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setTransactionTypeCode(dto.getTransactionTypeCode());
        entity.setServiceName(dto.getServiceName());

        return entity;
    }

    public List<TransactionDto> mapToDtos(List<Transaction> transactions) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactions) {
            transactionDtos.add(mapToDto(transaction));
        }
        return transactionDtos;
    }

    public List<Transaction> mapToEntities(List<TransactionDto> transactionDtos) {
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionDto transactionDto : transactionDtos) {
            transactions.add(mapToEntity(transactionDto));
        }
        return transactions;
    }
}
