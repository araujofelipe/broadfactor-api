package com.broadfactor.api.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EmpresaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
	
	String cnpj;
	LocalDateTime ultimaAtualizacao;
	String status;
	String complemento;
	String efr;
	String motivoSituacao;
	String situacaoEspecial;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	LocalDate dataSituacaoEspecial;
	
	Double capitalSocial;
	
	List<QuadroSocietarioDTO> qsa;
	
	@JsonIgnoreProperties({"empresasAtivPrincipal",  "empresasAtivSecundaria"})
	List<Atividade> atividadesSecundarias;
	
	@JsonIgnoreProperties({"empresasAtivPrincipal",  "empresasAtivSecundaria"})
	List<Atividade> atividadePrincipal;
}
