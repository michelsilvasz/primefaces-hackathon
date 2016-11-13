package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {

	@Inject
	private ProprietarioRepository proprietarioRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Proprietario buscarID(long id){
		
		return proprietarioRepository.buscarID(id);
		
	}
	
	public void adicionar(Proprietario proprietario){
		proprietarioRepository.incluir(proprietario);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Proprietario> listarProprietario(){
		return proprietarioRepository.listarProprietario();
	}
	
	public void excluirProprietario(Proprietario proprietario){
		proprietarioRepository.excluirProprietario(proprietario);
	}
}
