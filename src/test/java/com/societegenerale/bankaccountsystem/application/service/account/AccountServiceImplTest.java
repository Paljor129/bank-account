package com.societegenerale.bankaccountsystem.application.service.account;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.application.exception.ParameterException;
import com.societegenerale.bankaccountsystem.controller.mapper.AccountMapper;
import com.societegenerale.bankaccountsystem.controller.mapper.ClientMapper;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import com.societegenerale.bankaccountsystem.domain.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(classes = AccountServiceImpl.class)
class AccountServiceImplTest {

    @MockBean
    private AccountRepository accountRepository;
    @MockBean
    private AccountMapper accountMapper;
    @MockBean
    private ClientMapper clientMapper;

    @Autowired
    private AccountService accountService;

    @Test
    void when_accountId_null_should_throw_ParameterException() {
        final Long accountId = null;
        assertThrows(ParameterException.class,
                () -> this.accountService.credit(accountId, BigDecimal.valueOf(50D)));
    }

    @Test
    void when_amount_null_should_throw_ParameterException() {
        final BigDecimal amount = null;
        assertThrows(ParameterException.class,
                () -> this.accountService.credit(1L, amount));
    }

    @Test
    void when_amount_negative_should_throw_ParameterException() {
        final BigDecimal amount = BigDecimal.valueOf(-50D);
        assertThrows(ParameterException.class,
                () -> this.accountService.credit(1L, amount));
    }

    @Test
    void should_credit_account() throws NotFoundException {
        final Long accountId = 1L;
        final BigDecimal amount = BigDecimal.valueOf(50D);
        Account account = new Account();
        account.setId(accountId);
        account.setAccountNumber("1234567890");
        account.setActive(Boolean.TRUE);
        account.setBalance(amount);
        account.setOpenDate(LocalDateTime.now());

        Account expected = new Account();
        expected.setId(accountId);
        expected.setAccountNumber("1234567890");
        expected.setActive(Boolean.TRUE);
        expected.setBalance(BigDecimal.valueOf(100D));
        expected.setOpenDate(LocalDateTime.now());

        when(accountRepository.findById(accountId)).thenReturn(account);
        when(accountRepository.save(any(Account.class))).thenReturn(expected);

        Account result = accountService.findById(accountId);
        double currentBalance = result.getBalance().doubleValue();
        result = accountService.credit(accountId, amount);

        assertNotNull(result, "Result must exist");
        assertEquals(accountId, result.getId(), () -> "Result must have " + accountId + " as id");
        assertNotEquals(currentBalance, result.getBalance().doubleValue(), "Result must have a balance changed");
        assertEquals(currentBalance + 50D, result.getBalance().doubleValue(), "Result must have a wallet changed");
    }
}