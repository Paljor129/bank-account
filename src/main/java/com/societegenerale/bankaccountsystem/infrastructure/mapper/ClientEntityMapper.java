/*
package com.societegenerale.bankaccountsystem.infrastructure.mapper;

import com.societegenerale.bankaccountsystem.domain.model.Client;
import com.societegenerale.bankaccountsystem.domain.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientEntityMapper {

    private final AccountEntityMapper accountEntityMapper;

    public ClientEntityMapper(AccountEntityMapper accountEntityMapper) {
        this.accountEntityMapper = accountEntityMapper;
    }

    public Client toClient(ClientEntity clientEntity) {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.setLastName(clientEntity.getLastName());
        client.setFirstName(clientEntity.getFirstName());
        client.setSex(clientEntity.getSex());
        client.setDateOfBirth(clientEntity.getDateOfBirth());
        client.setAddress(clientEntity.getAddress());
        client.setPostalCode(clientEntity.getPostalCode());
        client.setTown(clientEntity.getTown());
        client.setEmail(clientEntity.getEmail());
        client.setPassword(clientEntity.getPassword());
        client.setPhone(clientEntity.getPhone());
        client.setRegistrationDate(clientEntity.getRegistrationDate());

        return client;
    };

    public ClientEntity toClientEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setLastName(client.getLastName());
        clientEntity.setFirstName(client.getFirstName());
        clientEntity.setSex(client.getSex());
        clientEntity.setDateOfBirth(client.getDateOfBirth());
        clientEntity.setAddress(client.getAddress());
        clientEntity.setPostalCode(client.getPostalCode());
        clientEntity.setTown(client.getTown());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setRegistrationDate(client.getRegistrationDate());

        return clientEntity;
    };

    public List<Client> toClientList(List<ClientEntity> clientEntities) {
        List<Client> clients = new ArrayList<>();
        for (ClientEntity clientEntity : clientEntities) {
            clients.add(toClient(clientEntity));
        }
        return clients;
    };

    public List<ClientEntity> toClientEntityList(List<Client> clients) {
        List<ClientEntity> clientEntities = new ArrayList<>();
        for (Client client : clients) {
            clientEntities.add(toClientEntity(client));
        }
        return clientEntities;
    };
}
*/
