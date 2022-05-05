package com.broadfactor.api.usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	public String nome;
	public String email;
	@Setter
	private String senha;
	public Empresa empresa;
}
