package com.stefanini.bean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.model.Modelo;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculos;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;
import java.io.Serializable;

@Named("veiculoBean")
@SessionScoped
public class VeiculoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -405802836147325587L;
	@Inject
	private Modelo modelo;
	@Inject
	private Categoria categoria;
	@Inject
	private Veiculos veiculo;
	@Inject
	private VeiculoService veiculoService;
	@Inject
	private Proprietario proprietario;
	@Inject
	private ProprietarioService proprietarioService;

	private long proprietarioCpf;

	public String salvarVeiculo() {

		

		try{
			modelo.setCategoria(categoria);
			veiculo.setModelo(modelo);
			veiculo.setProprietario(this.proprietario);
			veiculoService.incluir(veiculo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo salvo com sucesso"));
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
		return "/pages/index.jsf?faces-redirect=true";
	}

	public List<Veiculos> listarVeiculos() {
		return veiculoService.listar();
	}

	public void buscarPorID() {

		try {
			this.proprietario = proprietarioService.buscarID(this.proprietarioCpf);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proprietario Encontrado"));
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proprietario nao Encontrado"));
		}

		System.out.println(this.proprietario.getNome());
	}

	public void removerVeiculo(Veiculos veiculo) {
		veiculoService.removerVeiculo(veiculo);
	}
	


	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public long getProprietarioCpf() {
		return proprietarioCpf;
	}

	public void setProprietarioCpf(long proprietarioCpf) {
		this.proprietarioCpf = proprietarioCpf;
	}



}
