package com.societegenerale.bankaccountsystem.application.service.account;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.controller.dto.AccountDto;
import com.societegenerale.bankaccountsystem.domain.entity.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account create(AccountDto accountDto);

    Account findById(Long id) throws NotFoundException;

    Account credit(Long accountId, BigDecimal amount) throws NotFoundException;
}
