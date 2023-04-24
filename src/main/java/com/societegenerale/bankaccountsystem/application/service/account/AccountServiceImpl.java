package com.societegenerale.bankaccountsystem.application.service.account;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.application.exception.ParameterException;
import com.societegenerale.bankaccountsystem.controller.dto.AccountDto;
import com.societegenerale.bankaccountsystem.controller.mapper.AccountMapper;
import com.societegenerale.bankaccountsystem.controller.mapper.ClientMapper;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import com.societegenerale.bankaccountsystem.domain.entity.Transaction;
import com.societegenerale.bankaccountsystem.domain.repository.AccountRepository;
import com.societegenerale.bankaccountsystem.domain.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ClientMapper clientMapper;
    private final TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, ClientMapper clientMapper, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.clientMapper = clientMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public Account create(AccountDto dto) {
        LOGGER.debug("create - {}", dto);
        Account account = accountMapper.mapToEntity(dto);
        account.setClient(clientMapper.mapToEntity(dto.getClientDto()));
        Account result = accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(result);
        transaction.setAmount(result.getBalance());
        transaction.setTransactionTypeCode("Application");
        transaction.setServiceName("Open Account");
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);
        return result;
    }

    @Override
    public Account findById(Long id) throws NotFoundException {
        LOGGER.debug("findById - {}", id);
        return accountRepository.findById(id);
    }

    @Override
    @Transactional
    public Account credit(Long accountId, BigDecimal amount) throws NotFoundException {
        LOGGER.debug("credit - {} of {}", accountId, amount);
        if (accountId == null) {
            LOGGER.error("credit - account id is null");
            throw new ParameterException("Account id is null !", "accountId");
        }
        if (amount == null) {
            LOGGER.error("credit - amount is null");
            throw new ParameterException("amount is null !", "amount");
        }
        if (amount.doubleValue() <= 0) {
            LOGGER.error("credit - amount is negative");
            throw new ParameterException("amount is negative !", "amount");
        }

        Account account = accountRepository.findById(accountId);
        double actualbalance = account.getBalance().doubleValue();
        account.setBalance(BigDecimal.valueOf(actualbalance + amount.doubleValue()));
        Account resultUpdate = accountRepository.save(account);

        LOGGER.info("credit - OK new balance {}", account.getBalance().doubleValue());
        return resultUpdate;
    }
}
