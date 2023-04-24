package com.societegenerale.bankaccountsystem.infrastructure.repository.account;

import com.societegenerale.bankaccountsystem.application.exception.NotFoundException;
import com.societegenerale.bankaccountsystem.domain.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
@Sql("/data.sql")
class AccountRepositoryTest {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Test
    void should_find_account_by_id() throws NotFoundException {
        Long id = 1L;

        Optional<Account> expected = accountJpaRepository.findById(id);

        assertNotNull(expected);
        assertEquals(expected.get().getId(), 1);
        assertEquals(expected.get().getBalance().doubleValue(), 100D);
    }
}