package com.broadfactor.api.usuario;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
@JsonIgnoreProperties({"empresasAtivPrincipal", "empresasAtivSecundaria" })
public class Atividade {
	
	@Id
	@Column(name = "ATIVIDADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String text;
	String code;
	
	@ManyToMany(mappedBy = "atividadePrincipal", cascade = CascadeType.ALL)
	Set<Empresa> empresasAtivPrincipal;
	
	@ManyToMany(mappedBy = "atividadesSecundarias", cascade = CascadeType.ALL)
	Set<Empresa> empresasAtivSecundaria;
}
