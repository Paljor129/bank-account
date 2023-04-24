package com.societegenerale.bankaccountsystem.infrastructure.repository.account;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import com.societegenerale.bankaccountsystem.domain.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryImpl.class);

    private final AccountJpaRepository accountJpaRepository;

    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account save(Account account) {
        LOGGER.debug("account save - {}", account);
        account.setActive(Boolean.TRUE);
        account.setOpenDate(LocalDateTime.now());
        return accountJpaRepository.save(account);
    }

    @Override
    public Account findById(Long accountId) throws NotFoundException {
        LOGGER.debug("account findById - {}", accountId);
        return accountJpaRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Account with id " + accountId + " was not found"));
    }

}
