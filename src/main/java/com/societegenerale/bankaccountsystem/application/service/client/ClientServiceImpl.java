package com.societegenerale.bankaccountsystem.application.service.client;

import com.societegenerale.bankaccountsystem.application.exception.EntityAlreadySavedException;
import com.societegenerale.bankaccountsystem.application.exception.ParameterException;
import com.societegenerale.bankaccountsystem.domain.entity.Client;
import com.societegenerale.bankaccountsystem.domain.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client register(Client client) throws EntityAlreadySavedException {
        LOGGER.debug("register - {}", client);
        if (this.exist(client.getEmail())) {
            LOGGER.error("register - Client already in data base {}", client);
            throw new EntityAlreadySavedException(
                    "Utilisateur avec email=[" + client.getEmail() + "] est deja dans la base de donnees.");
        }
        return clientRepository.register(client);
    }

    @Override
    public List<Client> findAll() {
        LOGGER.debug("findAll -");
        return clientRepository.findAll();
    }

    @Override
    public Client findByEmail(String email) {
        LOGGER.debug("findByEmail - {}", email);
        return clientRepository.findByEmail(email);
    }

    @Transactional
    public boolean exist(String email) {
        if (email == null) {
            LOGGER.error("find - null?");
            throw new ParameterException("Email is null !", "email");
        }
        Optional<Client> foundClient = clientRepository.findOneByEmail(email);
        return foundClient.isPresent();
    }
}
