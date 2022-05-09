package com.broadfactor.api.usuario;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadfactor.api.common.Constantes;
import com.broadfactor.api.common.Singletons;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Constantes.PATH_API_VERSION + "/empresa")
@RequiredArgsConstructor
public class EmpresaController {
	
	private final EmpresaService service;
	private final UsuarioService usuarioService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDTO> detalhar(Authentication auth, @PathVariable Long id) throws UserPrincipalNotFoundException {
		Empresa empresa = service.detalhar(id);
		Usuario usuario = usuarioService.detalhar(auth.getName());
		if(!usuario.empresa.id.equals(empresa.id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else
		return new ResponseEntity<>(Singletons.instanceMapper().convertValue(empresa, EmpresaDTO.class), HttpStatus.OK);
	}
}
