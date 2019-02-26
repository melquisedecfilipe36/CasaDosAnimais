package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Exame;

public class ExameDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String descricao;
	
	Double valor;
	
	ExameDTO(){
		
	}
	ExameDTO(Exame e){
		
		this.id=e.getId();
		this.descricao=e.getDescricao();
		this.valor=e.getValor();	
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
