package com.societegenerale.bankaccountsystem.controller.mapper;

import com.societegenerale.bankaccountsystem.controller.dto.ClientDto;
import com.societegenerale.bankaccountsystem.domain.entity.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    /*private final AccountMapper accountMapper;

    public ClientMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }
*/
    public ClientDto mapToDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setSex(entity.getSex());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setAddress(entity.getAddress());
        dto.setPostalCode(entity.getPostalCode());
        dto.setTown(entity.getTown());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
//        dto.setAccounts(accountMapper.mapToDtos(entity.getAccounts()));

        return dto;
    }

    public Client mapToEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setSex(dto.getSex());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAddress(dto.getAddress());
        entity.setPostalCode(dto.getPostalCode());
        entity.setTown(dto.getTown());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());

        return entity;
    }

    public List<ClientDto> mapToDtos(List<Client> clients) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clients) {
            clientDtos.add(this.mapToDto(client));
        }
        return clientDtos;
    }
}
