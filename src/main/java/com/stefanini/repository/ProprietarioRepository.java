package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Proprietario;

public class ProprietarioRepository {

	@Inject
	private EntityManager manager;
	
	public Proprietario buscarID(long id){
		return this.manager.find(Proprietario.class,id);
	}
	
	public void incluir(Proprietario proprietario){
		this.manager.persist(proprietario);
	}
	
	public List<Proprietario> listarProprietario(){
		return this.manager.createQuery("select c from Proprietario c",Proprietario.class).getResultList();
	}
	
	public void excluirProprietario(Proprietario proprietario){
		this.manager.remove(proprietario);
	}
}
