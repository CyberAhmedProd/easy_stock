package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.CommandeClient;
import com.teamyostrik.easystock.repository.ClientRepository;
import com.teamyostrik.easystock.repository.CommandeClientRepository;
import com.teamyostrik.easystock.services.ClientService;
import com.teamyostrik.easystock.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty())
        {
            log.error("Categorie is not valid {}", clientDto);
            throw new EntityNotFoundExceptions("la catgorie n'est pas valide" ,  ErrorCode.CLIENT_NOT_FOUND );
        }
        return clientDto.fromEntity(
                clientRepository.save(ClientDto.toEntity(clientDto))
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null)
        {
            log.error("Client id is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun Client avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return  clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Entreprise ID is null");
            return;
        }
        List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
        if(!commandeClients.isEmpty())
        {
            throw new InvalideOperationException(
                    "impossible de supprimer un client qui a deja des commande clients",
                    ErrorCode.CLIENT_ALRAEDY_IN_USE
            );
        }
        clientRepository.deleteById(id);
    }
}
