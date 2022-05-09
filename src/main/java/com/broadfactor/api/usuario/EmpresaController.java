package com.broadfactor.api.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadfactor.api.common.Constantes;
import com.broadfactor.api.common.Singletons;

@RestController
@RequestMapping(Constantes.PATH_API_V1 + "/empresa")
public class EmpresaController {
	
	private final EmpresaService service;
	
	public EmpresaController(EmpresaService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDTO> detalhar(@PathVariable Long id) {
		Empresa empresa = service.detalhar(id);
		if(empresa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Singletons.instanceMapper().convertValue(empresa, EmpresaDTO.class), HttpStatus.OK);
	}
}
