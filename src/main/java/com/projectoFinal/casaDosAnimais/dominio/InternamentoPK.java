package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InternamentoPK implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="cirurgia_id")
	Cirurgia cirurgia;
	
	@ManyToOne
	@JoinColumn(name="tratamento_id")
	Tratamento tratamento;

	public Cirurgia getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Cirurgia cirurgia) {
		this.cirurgia = cirurgia;
	}

	public Tratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirurgia == null) ? 0 : cirurgia.hashCode());
		result = prime * result + ((tratamento == null) ? 0 : tratamento.hashCode());
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
		InternamentoPK other = (InternamentoPK) obj;
		if (cirurgia == null) {
			if (other.cirurgia != null)
				return false;
		} else if (!cirurgia.equals(other.cirurgia))
			return false;
		if (tratamento == null) {
			if (other.tratamento != null)
				return false;
		} else if (!tratamento.equals(other.tratamento))
			return false;
		return true;
	}
	
	
	
	
}
