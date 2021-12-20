package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCodeCommande(String codeCommandeClient);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
