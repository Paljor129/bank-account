package com.societegenerale.bankaccountsystem.domain.repository;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.domain.entity.Account;

public interface AccountRepository {

    Account save(Account account);

    Account findById(Long accountId) throws NotFoundException;
}
