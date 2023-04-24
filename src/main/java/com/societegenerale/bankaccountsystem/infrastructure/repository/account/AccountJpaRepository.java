package com.societegenerale.bankaccountsystem.infrastructure.repository.account;

import com.societegenerale.bankaccountsystem.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
