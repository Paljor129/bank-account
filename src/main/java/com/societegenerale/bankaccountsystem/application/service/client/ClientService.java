package com.societegenerale.bankaccountsystem.application.service.client;

import com.societegenerale.bankaccountsystem.application.exception.EntityAlreadySavedException;
import com.societegenerale.bankaccountsystem.domain.entity.Client;

import java.util.List;

public interface ClientService {

    Client register(Client client) throws EntityAlreadySavedException;

    List<Client> findAll();

    Client findByEmail(String email);
}
