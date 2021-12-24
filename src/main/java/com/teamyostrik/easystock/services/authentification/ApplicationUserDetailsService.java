package com.teamyostrik.easystock.services.authentification;

import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Utilisateur;
import com.teamyostrik.easystock.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByEmail(email).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun utilisateur avec l'email fourni", ErrorCode.UTILISATEUR_NOT_FOUND)
                );
        return new User(utilisateur.getEmail(),utilisateur.getMotDePasse(), Collections.emptyList());
    }
}
