package com.stefanini.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.model.Localinfracao;
import com.stefanini.model.Tipoinfracao;
import com.stefanini.model.Veiculos;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracaoService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.JSFUtil;

import java.io.Serializable;
import java.util.List;

@Named(value = "infracaoBean")
@SessionScoped
public class InfracoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1610423486689755730L;
	@Inject
	private Tipoinfracao tipoInfracoes;
	@Inject
	private Localinfracao localInfracao;
	@Inject
	private Agente agente;
	@Inject
	private Infracoes infracao;
	@Inject
	private Veiculos veiculo;
	@Inject
	private InfracaoService infracaoService;
	@Inject
	private AgenteService agenteService;
	private long cpfAgente;
	@Inject
	private VeiculoService veiculoService;

	public String salvarInfracao() {

		String url = "";
		try{
			infracao.setAgente(agente);
			infracao.setLocaisInfracoes(localInfracao);
			infracao.setTipoInfracao(tipoInfracoes);
			infracao.setVeiculo(veiculo);

			infracaoService.incluir(infracao);
			JSFUtil.msgSucesso("Infracao cadastrada");
			url = "index.jsf/faces-redirect=true";
			return url;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			JSFUtil.msgErro("Problema ao cadastrar Infracao");
		}
		return url;

	}

	public void buscarAgenteID() {
		try {
			this.agente = agenteService.buscarID(this.cpfAgente);
			JSFUtil.msgSucesso("Agente encontrado");
		} catch (RuntimeException e) {
			e.printStackTrace();
			JSFUtil.msgErro("Agente nao encontrado");
		}

	}

	// pesquisar por placa
	public void buscarPlaca() {

		try {
			this.veiculo = veiculoService.buscarPlaca(this.veiculo.getPlaca());
			JSFUtil.msgSucesso("Veiculo encontrado");
		} catch (RuntimeException e) {
			e.printStackTrace();
			JSFUtil.msgErro("Veiculo nao encontrado");
		}

	}

	public void pontoSelecionado(PointSelectEvent pse) {

		try {
			LatLng latlog = pse.getLatLng();

			this.localInfracao.setLatitude(latlog.getLat());
			this.localInfracao.setLongitude(latlog.getLng());
			JSFUtil.msgSucesso("Ponto selecionado");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	public List<Infracoes> listarInfracoes(){
		return infracaoService.listar();
	}
	
	public Tipoinfracao getTipoInfracoes() {
		return tipoInfracoes;
	}

	public void setTipoInfracoes(Tipoinfracao tipoInfracoes) {
		this.tipoInfracoes = tipoInfracoes;
	}

	public Localinfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(Localinfracao localInfracao) {
		this.localInfracao = localInfracao;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Infracoes getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracoes infracao) {
		this.infracao = infracao;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public InfracaoService getInfracaoService() {
		return infracaoService;
	}

	public void setInfracaoService(InfracaoService infracaoService) {
		this.infracaoService = infracaoService;
	}

	public AgenteService getAgenteService() {
		return agenteService;
	}

	public void setAgenteService(AgenteService agenteService) {
		this.agenteService = agenteService;
	}

	public long getCpfAgente() {
		return cpfAgente;
	}

	public void setCpfAgente(long cpfAgente) {
		this.cpfAgente = cpfAgente;
	}

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

}
