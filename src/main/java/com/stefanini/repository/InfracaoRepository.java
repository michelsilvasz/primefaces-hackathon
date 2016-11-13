package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.stefanini.model.Infracoes;


public class InfracaoRepository {

	
	@Inject
	private EntityManager manager;

	public void incluir(Infracoes infracao) {
		this.manager.persist(infracao);
	}

	public void altera(Infracoes infracao) {
		this.manager.merge(infracao);
	}

	public Infracoes busca(Integer id) {
		return this.manager.find(Infracoes.class, id);
	}

	public List<Infracoes> lista() {
		return this.manager.createQuery("select c from Infracoes c", Infracoes.class)
				.getResultList();
	}
	
	
}
