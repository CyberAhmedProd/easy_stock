package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    Optional<Entreprise> findById(Integer id);
}
