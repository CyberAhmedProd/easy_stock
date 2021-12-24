package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.ClientApi;
import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    @Autowired
    private ClientService clientService;
    @Override
    public ResponseEntity<ClientDto> create(ClientDto client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @Override
    public ResponseEntity<ClientDto> getById(Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }


    @Override
    public ResponseEntity<List<ClientDto>> getAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public void delete(Integer idClient) {
        clientService.delete(idClient);
    }
}
