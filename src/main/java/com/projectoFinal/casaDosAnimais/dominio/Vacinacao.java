package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vacinacao  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	VacinacaoPK id = new VacinacaoPK();
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDaVacinacao;
	
	String resultado;
	Double valor;
	Integer dose;
	
	Vacinacao(){
		
		
	}

	public Vacinacao(Vacina vacina,Tratamento tratamento, Date dataDaVacinacao, String resultado, Double valor, Integer dose) {
		super();
		id.setVacina(vacina);
		id.setTratamento(tratamento);
		
		this.dataDaVacinacao = dataDaVacinacao;
		this.resultado = resultado;
		this.valor = valor;
		this.dose = dose;
	}
	
	
	public double getSubTotal() {
		
		return valor * dose;
		
	}
	
	public Vacina getVacina() {
		
		return id.getVacina();
	}
	
	public Tratamento getTratamento() {
		
		return id.getTratamento();
	}
	
	public VacinacaoPK getId() {
		return id;
	}

	public void setId(VacinacaoPK id) {
		this.id = id;
	}

	public Date getDataDaVacinacao() {
		return dataDaVacinacao;
	}

	public void setDataDaVacinacao(Date dataDaVacinacao) {
		this.dataDaVacinacao = dataDaVacinacao;
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
		Vacinacao other = (Vacinacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
