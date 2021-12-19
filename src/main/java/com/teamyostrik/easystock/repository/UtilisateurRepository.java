package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
