package com.societegenerale.bankaccountsystem.infrastructure.repository.client;

import com.societegenerale.bankaccountsystem.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientJpaRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c join fetch c.accounts a where c.email = :email")
    Optional<Client> findByEmail(String email);

    Optional<Client> findOneByEmail(String email);
}
