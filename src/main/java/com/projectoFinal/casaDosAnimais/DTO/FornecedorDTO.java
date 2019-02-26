package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Fornecedor;

public class FornecedorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String nome;
	String email;
	
	FornecedorDTO(){
		
	}
	
	FornecedorDTO(Fornecedor f){
		this.id=f.getId();
		this.nome=f.getNome();
		this.email=f.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
