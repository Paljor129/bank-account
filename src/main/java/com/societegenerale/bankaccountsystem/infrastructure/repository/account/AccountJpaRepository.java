package com.societegenerale.bankaccountsystem.infrastructure.repository.account;

import com.societegenerale.bankaccountsystem.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
    @Query("select a from Account a join fetch a.transactions t where a.id = :id")
    Optional<Account> findById(Long id);
}
