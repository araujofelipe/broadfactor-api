package com.broadfactor.api.usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
	
	public Atividade atividadePrincipal;
	public LocalDate dataSituacao;
	public Tipo tipo;
	public String nome;
	public String uf;
	public String telefone;
	public String email;
	public Set<Atividade> atividadesSecundarias;
	public Situacao situacao;
	public String bairro;
	public String logradouro;
	public String numero;
	public String cep;
	public LocalDate abertura;
	public String naturezaJuridica;
	public String fantasia;
	public String cnpj;
	public LocalDateTime ultimaAtualizacao;
	public String status;
	public String complemento;
	public String efr;
	public String motivoSituacao;
	public String situacaoEspecial;
	public LocalDate dataSituacaoEspecial;
	public Double capitalSocial;
	public List<QuadroSocietario> qsa;
	public Usuario usuario;
}
