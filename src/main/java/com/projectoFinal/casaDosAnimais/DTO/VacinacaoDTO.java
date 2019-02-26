package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Vacinacao;

public class VacinacaoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String resultado;
	Double valor;
	Integer dose;
	
	VacinacaoDTO(){
		
	}
	
	VacinacaoDTO(Vacinacao v){
		this.resultado=v.getResultado();
		this.valor=v.getValor();
		this.dose=v.getDose();
		
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

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}
	
	
}
