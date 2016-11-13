package com.stefanini.model;
// Generated 07/11/2016 12:03:46 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Agente generated by hbm2java
 */
@Entity
@Table(name = "agente", catalog = "hackathon")
public class Agente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cpfAgente", unique = true, nullable = false)
	private long cpf;
	
	

	private String nome;
	private Date dtContratacao;
	private Integer tempoServico;

	@OneToMany(mappedBy = "agente")
	private List<Infracoes> infracoes;

	public Agente() {
	}

	public Agente(String nome, Date dtContratacao, Integer tempoServico) {
		this.nome = nome;
		this.dtContratacao = dtContratacao;
		this.tempoServico = tempoServico;
	}



	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	@Column(name = "nome", length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dtContratacao", length = 10)
	public Date getDtContratacao() {
		return this.dtContratacao;
	}

	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}

	@Column(name = "tempoServico")
	public Integer getTempoServico() {
		return this.tempoServico;
	}

	public void setTempoServico(Integer tempoServico) {
		this.tempoServico = tempoServico;
	}

	public List<Infracoes> getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(List<Infracoes> infracoes) {
		this.infracoes = infracoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}