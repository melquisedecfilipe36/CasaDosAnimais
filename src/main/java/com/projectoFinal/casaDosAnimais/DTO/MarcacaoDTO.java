package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Marcacao;

public class MarcacaoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String observacao;

	MarcacaoDTO (){
		
	}
	
	MarcacaoDTO (Marcacao marcacao){
		
		this.id=marcacao.getId();
		this.observacao=marcacao.getObservacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
