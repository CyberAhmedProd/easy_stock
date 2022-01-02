package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ChangerMotDePassUtilisateurDto;
import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.models.Fournisseur;
import com.teamyostrik.easystock.models.Utilisateur;
import com.teamyostrik.easystock.repository.UtilisateurRepository;
import com.teamyostrik.easystock.services.UtilisateurService;
import com.teamyostrik.easystock.validators.FournisseurValidator;
import com.teamyostrik.easystock.validators.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty())
        {
            log.error("Utilisateur is not valid {}", utilisateurDto);
            throw new EntityNotFoundExceptions("l'utilisateur n'est pas valide" ,  ErrorCode.UTILISATEUR_NOT_FOUND );
        }
        return utilisateurDto.fromEntity(
                utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto))
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null)
        {
            log.error("Fournisseur id is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun utilsateur avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return  utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundExceptions(
                                "Aucun utilisateur avec l'email" + email + "n'est ete trouver",
                                ErrorCode.UTILISATEUR_NOT_FOUND
                        ));
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePassUtilisateurDto changerMotDePassUtilisateurDto) {

        validate(changerMotDePassUtilisateurDto);
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(changerMotDePassUtilisateurDto.getId());
        if(!utilisateurOptional.isPresent())
        {
            log.warn("Aucun utilisateur avec L'ID" + changerMotDePassUtilisateurDto.getId());
            throw  new EntityNotFoundExceptions(
                    "Aucun utilisateur n'a ete trouve avec l'ID " +changerMotDePassUtilisateurDto.getId(),
                    ErrorCode.UTILISATEUR_NOT_FOUND
                    );
        }

        Utilisateur utilisateur = utilisateurOptional.get();
        utilisateur.setMotDePasse(changerMotDePassUtilisateurDto.getMotDePass());
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(utilisateur)
        );
    }

    private void validate(ChangerMotDePassUtilisateurDto changerMotDePassUtilisateurDto)
    {
        if(changerMotDePassUtilisateurDto  == null)
        {
            log.warn("impossible de modifier le mot de passe avec un object NULL");
            throw new InvalideOperationException
                    ("Aucune information n'est ete fourni pour pouvoir changer le mot de passe",
                            ErrorCode.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_FOUND
                    );
        }
        if(changerMotDePassUtilisateurDto.getId() == null)
        {
            log.warn("impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalideOperationException
                    ("ID utilisateur null, impossible de modifier le mot de passe",
                            ErrorCode.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_FOUND
                    );
        }
        if(!StringUtils.hasLength(changerMotDePassUtilisateurDto.getMotDePass()) || !StringUtils.hasLength(changerMotDePassUtilisateurDto.getConfirmMotDePasse()))
        {
            log.warn("impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalideOperationException
                    ("Mot de passe utilisateur null, impossible de modifier le mot de passe",
                            ErrorCode.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_FOUND
                    );
        }
        if(!changerMotDePassUtilisateurDto.getMotDePass().equals(changerMotDePassUtilisateurDto.getConfirmMotDePasse()))
        {
            log.warn("impossible de modifier le mot de passe avec deux mots de passes differents");
            throw new InvalideOperationException
                    ("Mots de passe utilisateur non conformes, impossible de modifier le mot de passe",
                            ErrorCode.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_FOUND
                    );
        }
    }
}
