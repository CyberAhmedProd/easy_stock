package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findClientById(Integer id);
    Optional<Client> findClientByCode(String code);
}
