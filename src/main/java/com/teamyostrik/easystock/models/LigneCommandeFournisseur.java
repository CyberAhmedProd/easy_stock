package com.teamyostrik.easystock.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{

}
