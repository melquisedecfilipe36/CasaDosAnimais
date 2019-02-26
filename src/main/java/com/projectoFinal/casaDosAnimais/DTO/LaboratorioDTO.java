package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Laboratorio;

public class LaboratorioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String nome;
	
	LaboratorioDTO(){
		
		
	}
	
	LaboratorioDTO(Laboratorio lab){
		this.id=lab.getId();
		this.nome=lab.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
