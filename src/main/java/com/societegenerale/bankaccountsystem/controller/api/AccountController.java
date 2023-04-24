package com.societegenerale.bankaccountsystem.controller.api;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.application.service.account.AccountService;
import com.societegenerale.bankaccountsystem.controller.dto.AccountDto;
import com.societegenerale.bankaccountsystem.controller.mapper.AccountMapper;
import com.societegenerale.bankaccountsystem.controller.mapper.ClientMapper;
import com.societegenerale.bankaccountsystem.controller.mapper.TransactionMapper;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final ClientMapper clientMapper;
    private final TransactionMapper transactionMapper;

    public AccountController(
            AccountService accountService,
            AccountMapper accountMapper,
            ClientMapper clientMapper,
            TransactionMapper transactionMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.clientMapper = clientMapper;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AccountDto> create(@RequestBody final AccountDto dto) {
        LOGGER.info("create Account : {}", dto);

        Account result = accountService.create(dto);
        AccountDto accountDto = accountMapper.mapToDto(result);
        accountDto.setClientDto(clientMapper.mapToDto(result.getClient()));

        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        LOGGER.info("findById - {}", id);

        Account account = accountService.findById(id);
        AccountDto accountDto = accountMapper.mapToDto(account);
        accountDto.setTransactions(transactionMapper.mapToDtos(account.getTransactions()));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping(path = "/credit/{accountId}")
    public ResponseEntity<AccountDto> credit(
            @PathVariable("accountId") Long accountId,
            @RequestParam("amount") BigDecimal amount
            ) throws NotFoundException {
        LOGGER.info("credit - {} of {}", accountId, amount);
        Account result = accountService.credit(accountId, amount);
        AccountDto accountDto = accountMapper.mapToDto(result);
        accountDto.setTransactions(transactionMapper.mapToDtos(result.getTransactions()));
        LOGGER.info("credit - Account {} is credited of {}", accountId, amount);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }
}
