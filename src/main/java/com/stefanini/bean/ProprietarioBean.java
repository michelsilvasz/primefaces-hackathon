package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefones;
import com.stefanini.model.Tipotelefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.TelefoneService;


@Named("proprietarioBean")
@SessionScoped
public class ProprietarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 127726332782663154L;
	@Inject
	private Proprietario proprietario;
	@Inject
	private Telefones telefones;
	@Inject
	private Tipotelefone tipoTelefone;
	@Inject
	private TelefoneService telefoneService;
	@Inject
	private ProprietarioService proprietarioService;
	
	public String salvarProprietario() {

		telefones.setProprietario(proprietario);
		telefones.setTipoTelefone(tipoTelefone);

		telefoneService.incluir(telefones);

		return "/pages/CadastrarVeiculo.jsf?faces-redirect=true";
	}

	public List<Proprietario> listarProprietario(){
		
		return proprietarioService.listarProprietario();
	}
	
	public void excluirProprietario(Proprietario proprietario){
		proprietarioService.excluirProprietario(proprietario);
	}
	
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefones getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefones telefones) {
		this.telefones = telefones;
	}

	public Tipotelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Tipotelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}


	

}
