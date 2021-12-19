package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
}
