package com.societegenerale.bankaccountsystem.domain.repository;

import com.societegenerale.bankaccountsystem.domain.entity.Transaction;

public interface TransactionRepository {

    Transaction save(Transaction transaction);
}
