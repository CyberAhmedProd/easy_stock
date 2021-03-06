package com.teamyostrik.easystock.models;

import java.io.Serializable;
import java.time.Instant;


import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AbstractEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id;
	@CreatedDate
	@Column(name = "creationDate", nullable = false, updatable = false)
	@JsonIgnore
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name = "lastUpdateDate")
	@JsonIgnore
	private Instant lastUpdateDate;

	/*@PrePersist
	void prePersist()
	{
		creationDate = Instant.now();
	}
	@PreUpdate
	void preUpdate()
	{
		lastUpdateDate = Instant.now();
	}*/




}
