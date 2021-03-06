package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.*;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.models.*;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.ClientRepository;
import com.teamyostrik.easystock.repository.CommandeClientRepository;
import com.teamyostrik.easystock.repository.LigneCommandeClientRepository;
import com.teamyostrik.easystock.services.CommandeClientService;
import com.teamyostrik.easystock.services.MouvementStockService;
import com.teamyostrik.easystock.validators.ArticleValidator;
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
    @Autowired
    private MouvementStockService mouvementStockService;
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
        checkIdCommande(idCommande);

        if(!StringUtils.hasLength(String.valueOf(etatCommande)))
        {
            log.error("l'etat de la commande Client is NULL");
            throw new InvalideOperationException("Impossible de modifier l'etat de la commande avec un etat NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }

        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);
        commandeClientDto.setEtatCommande(etatCommande);
        CommandeClient saveCommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
        updateMvtStock(idCommande);
        return CommandeClientDto.fromEntity(saveCommandeClient);
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, float quantite) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        if(quantite <=0)
        {
            log.error("la quantity de la ligne commande Client is ??ronn??");
            throw new InvalideOperationException("Impossible de modifier la commande avec une quantite de ligne Commande ??ronn??e ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);

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
        checkIdCommande(idCommande);
        if(idClient == null)
        {
            log.error("l'ID du Client is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec un ID client NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);

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
    public CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
       checkIdCommande(idCommande);
       checkIdLigneCommande(idLigneCommande);
       checkIdArticle(idArticle,"nouveau");
       CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);
       Optional<LigneCommandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);
       Optional<Article> articleOptional = articleRepository.findArticleById(idArticle);
       if (!articleOptional.isPresent())
           throw new EntityNotFoundExceptions("Aucun article n'ete trouver avec l'ID "+idArticle ,ErrorCode.ARTICLE_NOT_FOUND);
       List<String>  errors = ArticleValidator.validate(ArticleDto.fromEnity(articleOptional.get()));
       if(!errors.isEmpty())
       {
           throw new InvalideOperationException("Article invalide",ErrorCode.ARTICLE_NOT_VALID);
       }
       LigneCommandeClient ligneCommandeClient = ligneCommandeClientOptional.get();
       ligneCommandeClient.setArticle(articleOptional.get());
       ligneCommandeClientRepository.save(ligneCommandeClient);
       return commandeClientDto;
    }

    @Override
    public CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        CommandeClientDto commandeClientDto = checkEtatCommande(idCommande);
        //Check the ligneCommande in future
        ligneCommandeClientRepository.deleteById(idLigneCommande);
        return commandeClientDto;
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
    public List<LigneCommandeClientDto> findAllLignesCommandesByCommandeClientId(Integer idCommande) {
        return ligneCommandeClientRepository.findAllByCommandeClientId(idCommande).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Commande Client ID is NULL");
            return;
        }
        List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(id);
        if(!ligneCommandeClients.isEmpty())
        {
            throw new InvalideOperationException(
                    "impossible de supprimer une commande client deja utilisee",
                    ErrorCode.COMMANDE_CLIENT_ALRAEDY_IN_USE
            );
        }
        commandeClientRepository.deleteById(id);
    }

    private void checkIdCommande(Integer idCommande)
    {
        if(idCommande == null)
        {
            log.error("Commande Client ID is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
    }
    private void checkIdLigneCommande(Integer idLigneCommande){
        if(idLigneCommande == null)
        {
            log.error("l'ID de la ligne commande Client is NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec une ligne Commande NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        }
    }
    private void checkIdArticle(Integer idArticle, String msg)
    {
        if(idArticle == null)
        {
            log.error("L'ID de "+msg+" l'article de la ligne commande est NULL");
            throw new InvalideOperationException("Impossible de modifier la commande avec une ligne Commande avec un "+msg+" ID Article NULL ",ErrorCode.ARTICLE_NOT_FOUND);
        }
    }
    private CommandeClientDto checkEtatCommande(Integer idCommande)
    {
        CommandeClientDto commandeClientDto = findById(idCommande);
        if(commandeClientDto.isCommandeLivree())
            throw new InvalideOperationException("Impossible de modifier la commande avec ID NULL ",ErrorCode.COMMANDE_CLIENT_NOT_MODIFIABLE);
        return commandeClientDto;
    }

    private void updateMvtStock(Integer idClient)
    {
        List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(idClient);
        ligneCommandeClients.forEach(lig -> {
            MouvementSockDto sortieStock = MouvementSockDto.builder()
                    .article(ArticleDto.fromEnity(lig.getArticle()))
                    .typeMouvement(TypeMouvement.SORTIE)
                    .sourceMouvement(SourceMouvement.COMMANDE_CLIENT)
                    .quantite(lig.getQuantite())
                    .idEntreprise(lig.getIdEntreprise())
                    .build();
            mouvementStockService.sortieStock(sortieStock);
        });
    }
}
