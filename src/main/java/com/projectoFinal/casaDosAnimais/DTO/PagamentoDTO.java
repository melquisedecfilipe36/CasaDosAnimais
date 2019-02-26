package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import com.projectoFinal.casaDosAnimais.dominio.Pagamento;


public class PagamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String tipo;
	Double valorTotal;	
	Integer estadoPagamento;
	
	PagamentoDTO(){
		
		
	}
	
	
	PagamentoDTO(Pagamento p){
		
		this.id=p.getId();
		this.tipo=p.getTipo();
		this.valorTotal=p.getValorTotal();
		this.estadoPagamento=p.getEstadoPagamento().getCod();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}


	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}
	
	
}
