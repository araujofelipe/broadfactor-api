package com.broadfactor.api.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode
@Data
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	Long id;
	
	String nome;
	
	@Column(unique = true)
	String email;
	
	String senha;
	
	@ManyToOne
    @JoinColumn(name="EMPRESA_ID", nullable=false)
	Empresa empresa;
	
	public UsuarioDTO toDTO() {
		Empresa empresa_  = new Empresa();
		empresa_.id = this.empresa.id;
		return UsuarioDTO
		.builder()
		.nome(this.nome)
		.email(this.email)
		.empresa(empresa_)
		.build();
	}
}
