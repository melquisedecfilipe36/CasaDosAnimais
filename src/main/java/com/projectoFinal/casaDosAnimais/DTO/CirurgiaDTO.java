package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Cirurgia;

public class CirurgiaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String descricao;
	Double custo;

	CirurgiaDTO(){
		
		
	}
	
	CirurgiaDTO(Cirurgia cirurgia){
		
		this.id=cirurgia.getId();
		this.descricao=cirurgia.getDescricao();
		this.custo=cirurgia.getPreco();
		
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

	public Double getCusto() {
		return custo;
	}

	public void setCuto(Double custo) {
		this.custo = custo;
	}
	
	
}
