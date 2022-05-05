package com.broadfactor.api.usuario;

import static com.broadfactor.api.common.Singletons.instanceMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

	public final UsuarioRepository repository;
	public final EmpresaService empresaService;

	public UsuarioService(UsuarioRepository repository, EmpresaService empresaService) {
		this.repository = repository;
		this.empresaService = empresaService;
	}

	public Usuario criar(UsuarioDTO usuarioDTO) {
		Usuario usuario = instanceMapper().convertValue(usuarioDTO, Usuario.class);
		usuario.empresa = empresaService.salvar(usuario.empresa.cnpj);
		return repository.save(usuario);
	}

}
