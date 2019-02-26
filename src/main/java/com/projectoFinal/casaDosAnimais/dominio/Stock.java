package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Stock implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	StockPK id = new StockPK();
	
	private Integer quantidade;
	private Double desconto;
	private Double preco;
	
	Stock(){
		
		
	}

	public Stock(Consulta consulta,Produto produto, Integer quantidade, Double desconto, Double preco) {
		super();
		id.setConsulta(consulta);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.preco = preco;
	}

	public double getSubTotal() {
		
		return (preco - desconto)* quantidade;
		
	}
	
	public Consulta getConsulta() {
		
		return id.getConsulta();
	}
	
	public Produto getProduto() {
		
		return id.getProduto();
	}
	
	public StockPK getId() {
		return id;
	}

	public void setId(StockPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
