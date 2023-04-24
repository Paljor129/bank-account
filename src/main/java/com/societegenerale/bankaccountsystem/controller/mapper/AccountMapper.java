package com.societegenerale.bankaccountsystem.controller.mapper;

import com.societegenerale.bankaccountsystem.controller.dto.AccountDto;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    public AccountDto mapToDto(Account entity) {
        AccountDto dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setBalance(entity.getBalance());
        dto.setOpenDate(entity.getOpenDate());
        dto.setActive(entity.getActive());

        return dto;
    }

    public Account mapToEntity(AccountDto dto) {
        Account entity = new Account();
        entity.setId(dto.getId());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setBalance(dto.getBalance());
        entity.setOpenDate(dto.getOpenDate());
        entity.setActive(dto.getActive());

        return entity;
    }

    public List<AccountDto> mapToDtos(List<Account> accounts) {
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(mapToDto(account));
        }
        return accountDtos;
    }
}
