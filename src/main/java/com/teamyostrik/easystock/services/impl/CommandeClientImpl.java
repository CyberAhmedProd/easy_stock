package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.CommandeClient;
import com.teamyostrik.easystock.models.LigneCommandeClient;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.ClientRepository;
import com.teamyostrik.easystock.repository.CommandeClientRepository;
import com.teamyostrik.easystock.repository.LigneCommandeClientRepository;
import com.teamyostrik.easystock.services.CommandeClientService;
import com.teamyostrik.easystock.validators.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientImpl implements CommandeClientService {
    @Autowired
    private CommandeClientRepository commandeClientRepository;
    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> errors = CommandeClientValidator.validate(commandeClientDto);
        if(!errors.isEmpty())
        {
            log.error("Commande Client n'est pas valide");
            throw new EntityNotFoundExceptions("La commande client n'est pas valide",
                    ErrorCode.COMMANDE_CLIENT_NOT_FOUND);
        }
        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
        if(!client.isPresent())
        {
            log.warn("Client with ID {} is not found in DB",commandeClientDto.getClient().getId());
            throw new EntityNotFoundExceptions("Aucun client avec l'id "+commandeClientDto.getClient().getId()+
                    " n'est trouve dans le BD"
            ,ErrorCode.CLIENT_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();
        if(commandeClientDto.getLigneCommandeClients() != null)
        {
            commandeClientDto.getLigneCommandeClients().forEach(ligneCommandeClient -> {
                if(ligneCommandeClient.getArticle() != null)
                {
                    Optional<Article> article = articleRepository.findById(ligneCommandeClient.getArticle().getId());
                    if(!article.isPresent())
                    {
                        articleErrors.add("L'article avec l'ID "+ligneCommandeClient.getArticle().getId()+" n'exsite pas");
                    }
                }
                else
                {
                    articleErrors.add("impossible d'enregister une commande avec sans article");
                }
            });
        }
        if(!articleErrors.isEmpty())
        {
            log.warn("Article non existant");
            throw new EntityNotFoundExceptions("Article n'exite pas dans la BD"
            ,ErrorCode.ARTICLE_NOT_FOUND);
        }

        CommandeClient  savedCommandeClient =  commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
        if(commandeClientDto.getLigneCommandeClients() != null)
        {
            commandeClientDto.getLigneCommandeClients().forEach(ligneCommande -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCommande);
                ligneCommandeClient.setCommandeClient(savedCommandeClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }


        return CommandeClientDto.fromEntity(savedCommandeClient);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null)
        {
            log.error("Commande Client avec ID null");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Commande client n'a ete trouve avec l'ID "+id,
                        ErrorCode.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDto findByCodeCommande(String codeCommandeClient) {
        if(!StringUtils.hasLength(codeCommandeClient))
        {
            log.error("Commande Client avec Code NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCodeCommandeClient(codeCommandeClient)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Commande client n'a ete trouve avec le Code Commande Client "+codeCommandeClient,
                        ErrorCode.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Commande Client ID is NULL");
            return;
        }
        commandeClientRepository.deleteById(id);
    }

    private boolean check
}
