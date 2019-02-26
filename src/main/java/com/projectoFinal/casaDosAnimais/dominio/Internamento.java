package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Internamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	InternamentoPK id = new InternamentoPK();
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDoInternamento;
	
	String descricao;
	Integer numeroDeDias;
	public Integer getNumeroDeDias() {
		return numeroDeDias;
	}

	public void setNumeroDeDias(Integer numeroDeDias) {
		this.numeroDeDias = numeroDeDias;
	}

	Double valor;
	
	Internamento(){
		
	}

	public Internamento(Cirurgia cirurgia,Tratamento tratamento, Date dataDoInternamento, String descricao, Double valor) {
		super();
		id.setCirurgia(cirurgia);
		id.setTratamento(tratamento);
		this.dataDoInternamento = dataDoInternamento;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	
	public Internamento( Cirurgia cirurgia,Tratamento tratamento,Date dataDoInternamento, String descricao, Integer numeroDeDias,
			Double valor) {
		super();
		id.setCirurgia(cirurgia);
		id.setTratamento(tratamento);
		this.dataDoInternamento = dataDoInternamento;
		this.descricao = descricao;
		this.numeroDeDias = numeroDeDias;
		this.valor = valor;
	}

	public double getSubTotal() {
		
		return id.getCirurgia().getPreco() * numeroDeDias;
		
	}
	
	public Cirurgia getCirurgia() {
		
		return id.getCirurgia();
	}
	
	public Tratamento getTratamento() {
		
		return id.getTratamento();
	}

	public InternamentoPK getId() {
		return id;
	}

	public void setId(InternamentoPK id) {
		this.id = id;
	}

	public Date getDataDoInternamento() {
		return dataDoInternamento;
	}

	public void setDataDoInternamento(Date dataDoInternamento) {
		this.dataDoInternamento = dataDoInternamento;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Internamento other = (Internamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
