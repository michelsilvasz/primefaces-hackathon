package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Infracoes;
import com.stefanini.repository.InfracaoRepository;

@Stateless
public class InfracaoService {

	@Inject
	private InfracaoRepository infracaoRepository;
	
	
	
	public void incluir(Infracoes infracao){
		
		infracaoRepository.incluir(infracao);
		
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Infracoes> listar(){
		return infracaoRepository.lista();
	}
	
	
}
