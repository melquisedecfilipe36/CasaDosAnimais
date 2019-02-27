package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;
import java.util.Date;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class VeterinarioNewDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	private Date dataNascimentoVeterinario;
	
	Integer numeroDaOrdemDosVeterinarios;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	String especialidade;
		
	private Date dataMarcacao;
	private String observacaoMarcacao;
	private Integer auxiliarIdMarcacao;
	private Integer animalIdMarcacao;
	private Integer tipoMarcacao;
	
	
	private Date dataConsulta;
	private Double pesoDoAnimalConsulta;
	private String observacaoConsulta;
	private Integer animalIdConsulta;
	private Integer pagamentoIdConsulta;
	
	
	private String descricaoCirurgia;
	private Double precoCirurgia;
	
	private String descricaoVacina;
	private String indicacaoVacina;
	private String contraIndicacaoVacina;
	private Double valorVacina;
	private Date dataValidadeVacina;
	
	
	VeterinarioNewDTO(){
		
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDataNascimentoVeterinario() {
		return dataNascimentoVeterinario;
	}


	public void setDataNascimentoVeterinario(Date dataNascimentoVeterinario) {
		this.dataNascimentoVeterinario = dataNascimentoVeterinario;
	}


	public Integer getNumeroDaOrdemDosVeterinarios() {
		return numeroDaOrdemDosVeterinarios;
	}


	public void setNumeroDaOrdemDosVeterinarios(Integer numeroDaOrdemDosVeterinarios) {
		this.numeroDaOrdemDosVeterinarios = numeroDaOrdemDosVeterinarios;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public Date getDataMarcacao() {
		return dataMarcacao;
	}


	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}


	public String getObservacaoMarcacao() {
		return observacaoMarcacao;
	}


	public void setObservacaoMarcacao(String observacaoMarcacao) {
		this.observacaoMarcacao = observacaoMarcacao;
	}


	public Integer getAuxiliarIdMarcacao() {
		return auxiliarIdMarcacao;
	}


	public void setAuxiliarIdMarcacao(Integer auxiliarIdMarcacao) {
		this.auxiliarIdMarcacao = auxiliarIdMarcacao;
	}


	public Integer getAnimalIdMarcacao() {
		return animalIdMarcacao;
	}


	public void setAnimalIdMarcacao(Integer animalIdMarcacao) {
		this.animalIdMarcacao = animalIdMarcacao;
	}


	public Integer getTipoMarcacao() {
		return tipoMarcacao;
	}


	public void setTipoMarcacao(Integer tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}


	public Date getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public Double getPesoDoAnimalConsulta() {
		return pesoDoAnimalConsulta;
	}


	public void setPesoDoAnimalConsulta(Double pesoDoAnimalConsulta) {
		this.pesoDoAnimalConsulta = pesoDoAnimalConsulta;
	}


	public String getObservacaoConsulta() {
		return observacaoConsulta;
	}


	public void setObservacaoConsulta(String observacaoConsulta) {
		this.observacaoConsulta = observacaoConsulta;
	}


	public Integer getAnimalIdConsulta() {
		return animalIdConsulta;
	}


	public void setAnimalIdConsulta(Integer animalIdConsulta) {
		this.animalIdConsulta = animalIdConsulta;
	}


	public Integer getPagamentoIdConsulta() {
		return pagamentoIdConsulta;
	}


	public void setPagamentoIdConsulta(Integer pagamentoIdConsulta) {
		this.pagamentoIdConsulta = pagamentoIdConsulta;
	}


	public String getDescricaoCirurgia() {
		return descricaoCirurgia;
	}


	public void setDescricaoCirurgia(String descricaoCirurgia) {
		this.descricaoCirurgia = descricaoCirurgia;
	}


	public Double getPrecoCirurgia() {
		return precoCirurgia;
	}


	public void setPrecoCirurgia(Double precoCirurgia) {
		this.precoCirurgia = precoCirurgia;
	}


	public String getDescricaoVacina() {
		return descricaoVacina;
	}


	public void setDescricaoVacina(String descricaoVacina) {
		this.descricaoVacina = descricaoVacina;
	}


	public String getIndicacaoVacina() {
		return indicacaoVacina;
	}


	public void setIndicacaoVacina(String indicacaoVacina) {
		this.indicacaoVacina = indicacaoVacina;
	}


	public String getContraIndicacaoVacina() {
		return contraIndicacaoVacina;
	}


	public void setContraIndicacaoVacina(String contraIndicacaoVacina) {
		this.contraIndicacaoVacina = contraIndicacaoVacina;
	}


	public Double getValorVacina() {
		return valorVacina;
	}


	public void setValorVacina(Double valorVacina) {
		this.valorVacina = valorVacina;
	}


	public Date getDataValidadeVacina() {
		return dataValidadeVacina;
	}


	public void setDataValidadeVacina(Date dataValidadeVacina) {
		this.dataValidadeVacina = dataValidadeVacina;
	}


	
	

	
}
