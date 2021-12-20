package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.ClientApi;
import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    @Autowired
    private ClientService clientService;
    @Override
    public ClientDto create(ClientDto client) {
        return clientService.save(client);
    }

    @Override
    public ClientDto getById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto getByCode(String codeClient) {
        return clientService.findByCodeClient(codeClient);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer idClient) {
        clientService.delete(idClient);
    }
}
