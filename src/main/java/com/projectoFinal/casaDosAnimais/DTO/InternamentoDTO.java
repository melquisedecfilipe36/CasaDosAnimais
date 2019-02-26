package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Internamento;

public class InternamentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String descricao;
	Double valor;
	
	InternamentoDTO(){
		
	}
	
	InternamentoDTO(Internamento i){
		
		this.descricao=i.getDescricao();
		this.valor=i.getValor();
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
