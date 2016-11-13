package com.stefanini.controller;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;



@Path("/agente")
@RequestScoped
public class AgenteController {
	
		@Inject
		private AgenteService agenteService;
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Agente> get() {
		 
		
		 return agenteService.listarAgente();
	    }
	 	
	 	@POST
	 	@Consumes
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public String adicionarAgente(Agente agente){
	 		agenteService.incluir(agente);
	 		
	 		return "Agente adicionado com sucesso";
	 	}

	 	@DELETE
	 	@Path("/{id}")
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public String deletarAgente(@PathParam("id") Integer id){
	 		
	 		agenteService.excluir(id);
	 		return "Agente excluido com sucesso";
	 	}
	 	
}
