package com.broadfactor.api.usuario;

import static com.broadfactor.api.common.Singletons.restTemplate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
	
	@Value("${application.receitaws.uri}")
	public String receitaWSURI;
	
	private final EmpresaRepository repository;
	
	public EmpresaService(EmpresaRepository repository) {
		this.repository = repository;
	}
	
	public Empresa salvar(String cnpj) {
		Empresa empresa = consultarEmpresa(cnpj);
		return repository.saveAndFlush(empresa);
	}

	public Empresa consultarEmpresa(String cnpj) {
		return restTemplate().getForObject(String.format(receitaWSURI, cnpj), Empresa.class);
	}

	public Empresa detalhar(Long id) {
		Optional<Empresa> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
