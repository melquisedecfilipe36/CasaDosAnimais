package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Medicamento;

public class MedicamentoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	String nome;
	Double valor;
	Integer quantidade;
	
	MedicamentoDTO(){
		
		
	}
	
	MedicamentoDTO(Medicamento medicamento){
		
		this.id=medicamento.getId();
		this.nome=medicamento.getNome();
		this.valor=medicamento.getValor();
		this.quantidade=medicamento.getQuantidade();
		
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
