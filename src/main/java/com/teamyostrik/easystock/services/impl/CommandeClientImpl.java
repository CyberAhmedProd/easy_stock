package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.models.*;
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
        if(commandeClientDto.getId() != null && commandeClientDto.isCommandeLivree())
        {
            log.warn("Client with ID {} is not found in DB",commandeClientDto.getClient().getId());
            throw new InvalideOperationException("Impossible de modifier la commande lorsqu'elle est livree ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
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
    public CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        if(idCommande == null)
        {
            log.error("Commande Client ID is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        if(!StringUtils.hasLength(String.valueOf(etatCommande)))
        {
            log.error("l'etat de la commande Client is NULL");
            throw new InvalideOperationException("Impossible de modifier l'etat de la commande avec un etat NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }

        CommandeClientDto commandeClientDto = findById(idCommande);
        if(commandeClientDto.isCommandeLivree())
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        commandeClientDto.setEtatCommande(etatCommande);
        return CommandeClientDto.fromEntity(commandeClientRepository.save(
                CommandeClientDto.toEntity(commandeClientDto)
        ));
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, float quantite) {
        if(idCommande == null)
        {
            log.error("Commande Client ID is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        if(idLigneCommande == null)
        {
            log.error("l'ID de la ligne commande Client is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec une ligne Commande NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        if(quantite <=0)
        {
            log.error("la quantity de la ligne commande Client is éronné");
            throw new InvalideOperationException("Impossible de modifier la commande avec une quantite de ligne Commande éronnée ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        CommandeClientDto commandeClientDto = findById(idCommande);
        if(commandeClientDto.isCommandeLivree())
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);

        Optional<LigneCommandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);
        if(!ligneCommandeClientOptional.isPresent()) {
            new EntityNotFoundExceptions(
                    "Aucune Ligne Commande client n'a ete trouve avec l'ID "+idLigneCommande,
                    ErrorCode.LIGNE_COMMANDE_CLIENT_NOT_FOUND
            );
        }
        LigneCommandeClient ligneCommandeClient = ligneCommandeClientOptional.get();
        ligneCommandeClient.setQuantite(quantite);
        ligneCommandeClientRepository.save(ligneCommandeClient);
        return commandeClientDto;
    }

    @Override
    public CommandeClientDto updateClient(Integer idCommande, Integer idClient) {
        if(idCommande == null)
        {
            log.error("Commande Client ID is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        if(idClient == null)
        {
            log.error("l'ID du Client is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec un ID client NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        CommandeClientDto commandeClientDto = findById(idCommande);
        if(commandeClientDto.isCommandeLivree())
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);

        Optional<Client> clientOptional = clientRepository.findClientById(idClient);
        if(!clientOptional.isPresent())
        {
            new EntityNotFoundExceptions(
                    "Aucune  Commande client n'a ete trouve avec l'ID du Client  "+idClient,
                    ErrorCode.CLIENT_NOT_FOUND
            );
        }
        commandeClientDto.setClient(ClientDto.fromEntity(clientOptional.get()));
        return CommandeClientDto.fromEntity(
                commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto))
        );
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
}
