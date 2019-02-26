package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Municipio;

public class MunicipioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer id;
	String nome;
	
	MunicipioDTO(){
		
	}
	
	MunicipioDTO(Municipio municipio){
		this.id=municipio.getId();
		this.nome=municipio.getNome();
		
	}


}
