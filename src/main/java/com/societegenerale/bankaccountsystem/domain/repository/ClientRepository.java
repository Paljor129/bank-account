package com.societegenerale.bankaccountsystem.domain.repository;

import com.societegenerale.bankaccountsystem.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client register(Client client);

    List<Client> findAll();

    Client findByEmail(String email);

    Optional<Client> findOneByEmail(String email);
}
