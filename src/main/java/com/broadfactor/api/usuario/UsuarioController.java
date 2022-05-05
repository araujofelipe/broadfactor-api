package com.broadfactor.api.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadfactor.api.common.Constantes;

@RestController
@RequestMapping(Constantes.PATH_API_V1 + "/usuario")
public class UsuarioController {
	
	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuario) {
		return new ResponseEntity<>(service.criar(usuario).toDTO(), HttpStatus.OK);
	}
	
	public ResponseEntity<UsuarioDTO> detalhar(UsuarioDTO usuario) {
		return null;
	}
	
	public ResponseEntity<UsuarioDTO> editar(UsuarioDTO usuario, Long id) {
		return null;
	}
	
}
