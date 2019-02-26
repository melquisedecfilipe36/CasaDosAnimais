package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;

public class TipoMarcacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String descricao;
	
	TipoMarcacaoDTO(){
		
	}
	
	TipoMarcacaoDTO(TipoMarcacao tm){
		this.id=tm.getId();
		this.descricao=tm.getDescricao();
		
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
