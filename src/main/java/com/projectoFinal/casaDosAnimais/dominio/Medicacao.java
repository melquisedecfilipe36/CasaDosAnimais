package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Medicacao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	MedicacaoPK id = new MedicacaoPK();
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDaPrescricaoDaMedicacao;
	
	@Temporal(TemporalType.DATE)
	Date dataDeInicioDaMedicacao;
	
	@Temporal(TemporalType.DATE)
	Date dataDeFimDaMedicacao;
	
	Integer quantidade;
	Integer dose;
	
	Medicacao(){
		
		
	}

	public Medicacao(Medicamento medicamento,Tratamento tratamento, Date dataDaPrescricaoDaMedicacao, Date dataDeInicioDaMedicacao,
			Date dataDeFimDaMedicacao, Integer quantidade, Integer dose) {
		super();
		id.setMedicamento(medicamento);
		id.setTratamento(tratamento);
		this.dataDaPrescricaoDaMedicacao = dataDaPrescricaoDaMedicacao;
		this.dataDeInicioDaMedicacao = dataDeInicioDaMedicacao;
		this.dataDeFimDaMedicacao = dataDeFimDaMedicacao;
		this.quantidade = quantidade;
		this.dose = dose;
	}
	
	public double getSubTotal() {
		
		return id.medicamento.getValor()* quantidade;
		
	}
	
	public Medicamento getMedicamento() {
		
		return id.getMedicamento();
	}
	
	public Tratamento getTratamento() {
		
		return id.getTratamento();
	}

	public MedicacaoPK getId() {
		return id;
	}

	public void setId(MedicacaoPK id) {
		this.id = id;
	}

	public Date getDataDaPrescricaoDaMedicacao() {
		return dataDaPrescricaoDaMedicacao;
	}

	public void setDataDaPrescricaoDaMedicacao(Date dataDaPrescricaoDaMedicacao) {
		this.dataDaPrescricaoDaMedicacao = dataDaPrescricaoDaMedicacao;
	}

	public Date getDataDeInicioDaMedicacao() {
		return dataDeInicioDaMedicacao;
	}

	public void setDataDeInicioDaMedicacao(Date dataDeInicioDaMedicacao) {
		this.dataDeInicioDaMedicacao = dataDeInicioDaMedicacao;
	}

	public Date getDataDeFimDaMedicacao() {
		return dataDeFimDaMedicacao;
	}

	public void setDataDeFimDaMedicacao(Date dataDeFimDaMedicacao) {
		this.dataDeFimDaMedicacao = dataDeFimDaMedicacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		Medicacao other = (Medicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
