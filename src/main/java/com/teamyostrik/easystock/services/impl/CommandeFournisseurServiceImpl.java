package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.CommandeFournisseurDto;
import com.teamyostrik.easystock.dto.LigneCommandeFournisseurDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.*;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.CommandeFournisseurRepository;
import com.teamyostrik.easystock.repository.LigneCommandeFournisseurRepository;
import com.teamyostrik.easystock.services.CommandeFournisseurService;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors  = new ArrayList<>();
        if(!errors.isEmpty())
        {
            log.error("Commande Fournisseur n'est pas valide");
            throw new EntityNotFoundExceptions("La commande fournisseur n'est pas valide",
                    ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND);
        }
        Optional<CommandeFournisseur> fournisseur = commandeFournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
        if(!fournisseur.isPresent())
        {
            log.warn("Fournisseur with ID {} is not found in DB",commandeFournisseurDto.getFournisseur().getId());
            throw new EntityNotFoundExceptions("Aucun fournisseur avec l'id "+commandeFournisseurDto.getFournisseur().getId()+
                    " n'est trouve dans le BD"
                    ,ErrorCode.FOURNISSEUR_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();
        if(commandeFournisseurDto.getLigneCommandeFournisseurs() != null)
        {
            commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligneCommandeFournisseur -> {
                if(ligneCommandeFournisseur.getArticle() != null)
                {
                    Optional<Article> article = articleRepository.findById(ligneCommandeFournisseur.getArticle().getId());
                    if(!article.isPresent())
                    {
                        articleErrors.add("L'article avec l'ID "+ligneCommandeFournisseur.getArticle().getId()+" n'exsite pas");
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

        CommandeFournisseur savedCommandeFournisseur =  commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
        if(commandeFournisseurDto.getLigneCommandeFournisseurs() != null)
        {
            commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligneCommande -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligneCommande);
                ligneCommandeFournisseur.setCommandeFournisseurs(savedCommandeFournisseur);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null)
        {
            log.error("Commande Client avec ID null");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Commande Fournisseur n'a ete trouve avec l'ID "+id,
                        ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findByCodeCommande(String codeCommandeFournisseur) {
        if(!StringUtils.hasLength(codeCommandeFournisseur))
        {
            log.error("Commande Fournisseur avec Code NULL");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCodeCommande(codeCommandeFournisseur)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundExceptions(
                        "Aucune Commande Fournisseur n'a ete trouve avec le Code Commande Client "+codeCommandeFournisseur,
                        ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Commande Fournisseur ID is NULL");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
