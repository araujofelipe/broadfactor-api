package com.broadfactor.api.usuario;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadfactor.api.common.Constantes;

@RestController
@RequestMapping(Constantes.PATH_API_VERSION + "/usuario")
public class UsuarioController {
	
	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuario) {
		return new ResponseEntity<>(service.criar(usuario).toDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> detalhar(Authentication auth) throws UserPrincipalNotFoundException {
		
		Usuario user = service.detalhar(auth.getName());
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user.toDTO(), HttpStatus.OK);
	}
}
