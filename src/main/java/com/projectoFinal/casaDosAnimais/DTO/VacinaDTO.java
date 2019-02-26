package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Vacina;

public class VacinaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String descricao;
	String indicacao;
	String contraIndicacao;
	Double valor;
	
	 VacinaDTO(){
		 
		 
	 }
	 
	 VacinaDTO(Vacina v){
		 this.id=v.getId();
		 this.descricao=v.getDescricao();
		 this.contraIndicacao=v.getContraIndicacao();
		 this.indicacao=v.getIndicacao();
		 this.valor=v.getValor();
		 
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	 	
}
