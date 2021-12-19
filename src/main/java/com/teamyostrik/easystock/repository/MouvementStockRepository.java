package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.MouvementSock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementSock,Integer> {
}
