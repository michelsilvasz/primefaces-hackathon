package com.stefanini.model;
// Generated 07/11/2016 12:03:46 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;



import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Infracoes generated by hbm2java
 */
@Entity
@Table(name = "infracoes", catalog = "hackathon")
public class Infracoes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idInfracao", unique = true, nullable = false)
	private Integer idInfracao;
	private Integer velocidade;

	// id agente
	@ManyToOne
	@JoinColumn(name = "idAgente", nullable = false)
	private Agente agente;
	// id tipo da infracao

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipoInfracao", nullable = false)
	private Tipoinfracao tipoInfracao;
	
	
	// id local da infracao
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLocalInfracao", nullable = false)
	private Localinfracao locaisInfracoes;
	
	
	// id placa do veiculo
	@ManyToOne
	@JoinColumn(name = "placa")
	private Veiculos veiculo;

	public Infracoes() {
	}


	public Integer getIdInfracao() {
		return this.idInfracao;
	}

	public void setIdInfracao(Integer idInfracao) {
		this.idInfracao = idInfracao;
	}

	@Column(name = "velocidade")
	public Integer getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Tipoinfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(Tipoinfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

	

	public Localinfracao getLocaisInfracoes() {
		return locaisInfracoes;
	}

	public void setLocaisInfracoes(Localinfracao locaisInfracoes) {
		this.locaisInfracoes = locaisInfracoes;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

}