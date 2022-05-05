package com.broadfactor.api.usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	public String nome;
	public String email;
	@Setter
	private String senha;
	public Empresa empresa;
	
	public UsuarioDTO toDTO() {
		return null;
	}
}
