package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Raca;

public class RacaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String descricao;
	
	RacaDTO(){
		
	}
	
	RacaDTO(Raca r){
		
		this.id=r.getId();
		this.descricao=r.getDescricao();
		
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
	
}
