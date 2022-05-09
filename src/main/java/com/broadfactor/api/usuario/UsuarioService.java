package com.broadfactor.api.usuario;

import static com.broadfactor.api.common.Singletons.instanceMapper;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

	private final UsuarioRepository repository;
	private final EmpresaService empresaService;
	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuario.getRoles().stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
		return new User(usuario.email, usuario.senha, authorities);
	}
	
	public Usuario criar(UsuarioDTO usuarioDTO) {
		Usuario usuario = instanceMapper().convertValue(usuarioDTO, Usuario.class);
		usuario.senha = passwordEncoder.encode(usuarioDTO.senha);
		usuario.empresa = empresaService.salvar(usuarioDTO.empresa.cnpj);
		return repository.saveAndFlush(usuario);
	}

	public Usuario detalhar(String email) throws UserPrincipalNotFoundException {
		Usuario usuario = repository.findByEmail(email);
		if(usuario == null) {
			throw new UserPrincipalNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}

	

}
