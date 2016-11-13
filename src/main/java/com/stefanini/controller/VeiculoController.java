package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculos;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;

@Path("/veiculo")
@RequestScoped
public class VeiculoController {

	@Inject
	private VeiculoService veiculoService;
	@Inject
	private ProprietarioService proprietarioService;
	
	
	@POST
 	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.APPLICATION_JSON)
 	public String cadastrarVeiculo(Veiculos veiculo){
 		
			veiculoService.incluir(veiculo);

 		return "Agente adicionado com sucesso";
 	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veiculos> listaVeiculos(){
		
		return veiculoService.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pesquisarProprietario/{cpf}")
	public Proprietario pesquisarProprietario(@PathParam("cpf") long cpf){
		Proprietario proprietario=null;
		
		try{
			proprietario = proprietarioService.buscarID(cpf);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return proprietario;
		
	}
	
}
