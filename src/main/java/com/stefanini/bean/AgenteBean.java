package com.stefanini.bean;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import java.io.Serializable;





@Named("agenteBean")
@SessionScoped
public class AgenteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7823908501987992622L;
	@Inject
	private Agente agente;
	@Inject
	private AgenteService agenteService;
	
	
	public String salvarAgente(){
		
		agenteService.incluir(agente);
		
		return "/pages/index.xhtml?faces-redirect=true";
		
	}

	public Integer calculaTempoServico(Date dataContratacao){
		
		Date hoje = new Date();
		@SuppressWarnings("deprecation")
		int tempo = hoje.getYear() - dataContratacao.getYear();
		
		return tempo;
	}
	
	public List<Agente> listarAgente(){
		return agenteService.listarAgente();
	}
	
	public void removerAgente(Integer id){
		agenteService.excluir(id);
	}
	
	public String exibir(){
		
		return "/pages/teste.xhtml";
		
	}
	
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
	
	
}
