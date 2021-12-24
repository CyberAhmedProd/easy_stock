package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CommandeClientApi;
import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommandeClientController implements CommandeClientApi {
    @Autowired
    private CommandeClientService commandeClientService;
    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        return commandeClientService.save(commandeClientDto);
    }

    @Override
    public CommandeClientDto findById(Integer IdCommandeClient) {
        return commandeClientService.findById(IdCommandeClient);
    }

    @Override
    public CommandeClientDto findByCodeCommande(String codeCommandeClient) {
        return commandeClientService.findByCodeCommande(codeCommandeClient);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void delete(Integer idCommandeClient) {
        commandeClientService.delete(idCommandeClient);
    }
}
