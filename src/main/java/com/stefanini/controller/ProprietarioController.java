package com.stefanini.controller;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Proprietario;
import com.stefanini.service.ProprietarioService;

@Path("/proprietario")
@RequestScoped
public class ProprietarioController {

	@Inject
	private ProprietarioService proprietarioService;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String adicionarProprietario(Proprietario proprietario){
		
		proprietarioService.adicionar(proprietario);
		return "Adicionado com sucesso";
		
	}
	
	
	
	
	
}
