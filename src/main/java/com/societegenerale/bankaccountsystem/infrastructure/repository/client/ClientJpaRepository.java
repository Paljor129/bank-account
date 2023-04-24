package com.societegenerale.bankaccountsystem.infrastructure.repository.client;

import com.societegenerale.bankaccountsystem.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientJpaRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findOneByEmail(String email);
}
