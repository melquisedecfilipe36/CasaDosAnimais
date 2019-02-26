package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.ExameLaboratorial;

public class ExameLaboratorialDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String descricao;
	String resultado;
	Double valor;
	
	ExameLaboratorialDTO(){
		
		
	}
	
	ExameLaboratorialDTO(ExameLaboratorial exm){
		
		this.descricao=exm.getDescricao();
		this.resultado=exm.getResultado();
		this.valor=exm.getValor();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
		
}
