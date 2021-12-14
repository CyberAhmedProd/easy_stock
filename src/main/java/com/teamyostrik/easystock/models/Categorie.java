package com.teamyostrik.easystock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="categorie")
public class Categorie extends AbstractEntity{

	@Column(name = "code_categorie")
	private String codeCategorie;
	@Column(name = "designation")
	private String designation	;
	@OneToMany(mappedBy= "category")
	private List<Article> articles;




}