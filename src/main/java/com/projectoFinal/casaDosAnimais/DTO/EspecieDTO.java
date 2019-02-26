package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Especie;

public class EspecieDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String descricao;
	
	EspecieDTO(){
		
		
	}
	
	EspecieDTO(Especie e){
		this.id=e.getId();
		this.descricao=e.getDescricao();
		
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
