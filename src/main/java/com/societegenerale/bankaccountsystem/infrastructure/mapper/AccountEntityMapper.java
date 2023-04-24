/*
package com.societegenerale.bankaccountsystem.infrastructure.mapper;

import com.societegenerale.bankaccountsystem.domain.model.Account;
import com.societegenerale.bankaccountsystem.domain.entity.AccountEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountEntityMapper {

    public Account toAccount(AccountEntity accountEntity) {
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setAccountNumber(accountEntity.getAccountNumber());
        account.setBalance(accountEntity.getBalance());
        account.setActive(accountEntity.getActive());
        account.setOpenDate(accountEntity.getOpenDate());

        return account;
    };

    public AccountEntity toAccountEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(account.getAccountNumber());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setActive(account.getActive());
        accountEntity.setOpenDate(account.getOpenDate());

        return accountEntity;
    };

    public List<Account> toAccounts(List<AccountEntity> accountEntities) {
        List<Account> accounts = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntities) {
            accounts.add(this.toAccount(accountEntity));
        }
        return accounts;
    }

    public List<AccountEntity> toAccountEntities(List<Account> accounts) {
        List<AccountEntity> accountEntities = new ArrayList<>();
        for (Account account : accounts) {
            accountEntities.add(this.toAccountEntity(account));
        }
        return accountEntities;
    }

}
*/
