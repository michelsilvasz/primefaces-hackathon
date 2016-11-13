package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.stefanini.model.Veiculos;

public class VeiculoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Veiculos veiculo) {
		this.manager.persist(veiculo);
	}

	public void altera(Veiculos veiculo) {
		this.manager.merge(veiculo);
	}

	public Veiculos busca(Integer id) {
		return this.manager.find(Veiculos.class, id);
	}

	public Veiculos buscaPlaca(String placa) {
		return this.manager.find(Veiculos.class,placa);
	}
	
	
	public List<Veiculos> lista() {
		return this.manager.createQuery("select c from Veiculos c", Veiculos.class)
				.getResultList();
	}
	
	public void removerVeiculo(Veiculos veiculo){
		this.manager.remove(veiculo);
	}
	
}
