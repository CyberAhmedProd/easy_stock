package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
}
