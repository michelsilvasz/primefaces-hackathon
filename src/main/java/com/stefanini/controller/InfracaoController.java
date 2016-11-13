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
import com.stefanini.model.Infracoes;
import com.stefanini.model.Veiculos;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracaoService;
import com.stefanini.service.VeiculoService;




@Path("/infracao")
@RequestScoped
public class InfracaoController {

	@Inject
	private InfracaoService infracaoService;
	@Inject
	private AgenteService agenteService;
	@Inject
	private VeiculoService veiculoService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cadastrarInfracao(Infracoes infracao){
		
		infracaoService.incluir(infracao);
		
		return "Infracao adicionada com sucesso";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Infracoes> listarInfracao(){
		
		return infracaoService.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscarAgente/{cpf}")
	public Agente buscarAgente(@PathParam("cpf") long cpf){
		
		Agente agente=null;
		try{
			agente = agenteService.buscarID(cpf);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return agente;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscarVeiculo/{placa}")
	public Veiculos buscarVeiculo(@PathParam("placa") String placa){
		
		Veiculos veiculo = null;
		
		try{
			veiculo = veiculoService.buscarPlaca(placa);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return veiculo;
	}
	
	
}
