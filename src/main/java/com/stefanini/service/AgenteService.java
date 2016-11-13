package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {

	@Inject
	private AgenteRepository agenteRepository;

	public void incluir(Agente agente) {
		agenteRepository.incluir(agente);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Agente buscarID(long id) {

		return agenteRepository.busca(id);

	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Agente> listarAgente(){
		
		return agenteRepository.listaAgente();
	}
	
	public void excluir(Integer id){
		agenteRepository.deletar(id);
	}
	
}
