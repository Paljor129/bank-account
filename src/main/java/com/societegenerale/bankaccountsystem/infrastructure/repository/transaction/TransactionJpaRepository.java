package com.societegenerale.bankaccountsystem.infrastructure.repository.transaction;

import com.societegenerale.bankaccountsystem.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<Transaction, Long> {
}
