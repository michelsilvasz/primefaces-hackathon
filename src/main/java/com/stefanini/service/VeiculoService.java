package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculos;
import com.stefanini.repository.VeiculoRepository;

@Stateless
public class VeiculoService {

	
	@Inject
	private VeiculoRepository veiculoRepository;
	
	
    public void incluir(Veiculos veiculo){
        veiculoRepository.incluir(veiculo);
	
	}
 
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Veiculos buscarPlaca(String placa){
		return veiculoRepository.buscaPlaca(placa);
	}
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Veiculos> listar(){
    	return veiculoRepository.lista();
    	
    }
    
    public void removerVeiculo(Veiculos veiculo){
    	veiculoRepository.removerVeiculo(veiculo);
    }
    
    
    
    
}
	
