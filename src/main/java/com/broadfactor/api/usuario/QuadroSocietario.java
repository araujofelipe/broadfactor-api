package com.broadfactor.api.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode
@JsonIgnoreProperties(value = {"empresa"})
public class QuadroSocietario {
	
	@Id
	@Column(name = "QSA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	String nome;
	String qual;
	
	@ManyToOne
	@JoinColumn(name = "EMPRESA_ID")
	Empresa empresa;
}
