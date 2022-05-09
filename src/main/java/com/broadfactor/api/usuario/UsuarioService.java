package com.broadfactor.api.usuario;

import static com.broadfactor.api.common.Singletons.instanceMapper;

import java.util.Optional;

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
		usuario.empresa = empresaService.salvar(usuarioDTO.empresa.cnpj);
		return repository.saveAndFlush(usuario);
	}

	public Usuario detalhar(Long id) {
		Optional<Usuario> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
