package com.societegenerale.bankaccountsystem.controller.api;

import com.societegenerale.bankaccountsystem.application.exception.EntityAlreadySavedException;
import com.societegenerale.bankaccountsystem.application.service.client.ClientService;
import com.societegenerale.bankaccountsystem.controller.dto.ClientDto;
import com.societegenerale.bankaccountsystem.controller.mapper.AccountMapper;
import com.societegenerale.bankaccountsystem.controller.mapper.ClientMapper;
import com.societegenerale.bankaccountsystem.domain.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientMapper clientMapper;
    private final AccountMapper accountMapper;
    private final ClientService clientService;

    public ClientController(ClientMapper clientMapper, AccountMapper accountMapper, ClientService clientService) {
        this.clientMapper = clientMapper;
        this.accountMapper = accountMapper;
        this.clientService = clientService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ClientDto> register(@RequestBody ClientDto dto) throws EntityAlreadySavedException {
        LOGGER.info("subscribe - {}", dto);

        Client client = clientMapper.mapToEntity(dto);
        client.setAccounts(new ArrayList<>());
        Client result = clientService.register(client);
        ClientDto clientDto = clientMapper.mapToDto(result);

        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping(path = "/findall")
    public ResponseEntity<List<ClientDto>> findAll() {
        LOGGER.info("findAll - {}");
        List<Client> result = clientService.findAll();
        List<ClientDto> clientDtos = clientMapper.mapToDtos(result);

        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{email}")
    public ResponseEntity<ClientDto> findByEmail(@PathVariable("email") String email) {
        LOGGER.info("findByEmail - {}", email);
        Client result = clientService.findByEmail(email);
        ClientDto clientDto = clientMapper.mapToDto(result);
        clientDto.setAccounts(accountMapper.mapToDtos(result.getAccounts()));

        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }
}
