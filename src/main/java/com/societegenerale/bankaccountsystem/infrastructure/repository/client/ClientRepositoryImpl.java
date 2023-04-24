package com.societegenerale.bankaccountsystem.infrastructure.repository.client;

import com.societegenerale.bankaccountsystem.domain.entity.Client;
import com.societegenerale.bankaccountsystem.domain.entity.Role;
import com.societegenerale.bankaccountsystem.domain.entity.enums.RoleEnum;
import com.societegenerale.bankaccountsystem.domain.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepositoryImpl.class);

    private final ClientJpaRepository clientJpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public Client register(Client client) {
        LOGGER.debug("register({})", client);
        if (client.getRoles() == null || client.getRoles().isEmpty()) {
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(RoleEnum.ROLE_USER, client));
            client.setRoles(roles);
        }
        client.setRegistrationDate(LocalDateTime.now());

        return clientJpaRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        LOGGER.debug("client findAll");
        return clientJpaRepository.findAll();
    }

    @Override
    public Client findByEmail(String email) {
        LOGGER.debug("findByEmail - {}", email);
        return clientJpaRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Optional<Client> findOneByEmail(String email) {
        LOGGER.debug("findOneByEmail - {}", email);
        return clientJpaRepository.findOneByEmail(email);
    }
}
