package com.broadfactor.api.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Optional<Empresa> findByIdAndUsuario(Long id, Usuario usuario);
}
