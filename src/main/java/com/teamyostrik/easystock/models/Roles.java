package com.teamyostrik.easystock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="roles")
public class Roles extends AbstractEntity{

	@Column(name ="role_name")
	private String roleName;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisteur")
	private Utilisateur utilisateur;
}
