package com.broadfactor.api.usuario;

import static com.broadfactor.api.common.Singletons.restTemplate;

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
		return repository.save(empresa);
	}

	public Empresa consultarEmpresa(String cnpj) {
		return restTemplate().getForObject(String.format(receitaWSURI, cnpj), Empresa.class);
	}

}
