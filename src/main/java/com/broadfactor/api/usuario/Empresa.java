package com.broadfactor.api.usuario;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(exclude ="qsa")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Empresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "EMPRESA_ID")
	Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	LocalDate dataSituacao;
	Tipo tipo;
	String nome;
	String uf;
	String telefone;
	String email;
	
	
	
	Situacao situacao;
	String bairro;
	String logradouro;
	String numero;
	String cep;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	LocalDate abertura;
	
	String naturezaJuridica;
	String fantasia;
	
	@Column(unique = true)
	String cnpj;
	LocalDateTime ultimaAtualizacao;
	String status;
	String complemento;
	String efr;
	String motivoSituacao;
	String situacaoEspecial;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	LocalDate dataSituacaoEspecial;
	
	Double capitalSocial;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	List<QuadroSocietario> qsa;
	
	@JsonAlias("atividades_secundarias")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="EMPRESA_ATIVIDADE_SECUNDARIA")
	List<Atividade> atividadesSecundarias;
	
	@JsonAlias("atividade_principal")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="EMPRESA_ATIVIDADE_PRINCIPAL")
	List<Atividade> atividadePrincipal;
	
	@OneToMany
	Set<Usuario> usuario;
	
	@PrePersist
	private void setSocios() {
		List<QuadroSocietario> socios = this.qsa.stream().map(socio ->  {
			socio.empresa = this;
			return socio;
		}).collect(toList());
		this.qsa = socios;
	}
}
