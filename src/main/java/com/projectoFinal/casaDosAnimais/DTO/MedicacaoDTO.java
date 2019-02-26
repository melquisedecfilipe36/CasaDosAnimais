package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.projectoFinal.casaDosAnimais.dominio.Medicacao;

public class MedicacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDaPrescricaoDaMedicacao;
	
	@Temporal(TemporalType.DATE)
	Date dataDeInicioDaMedicacao;
	
	@Temporal(TemporalType.DATE)
	Date dataDeFimDaMedicacao;
	
	Integer dose;
	
	MedicacaoDTO(){
		
		
	}
	
	MedicacaoDTO(Medicacao med){
		
		this.dataDaPrescricaoDaMedicacao=med.getDataDaPrescricaoDaMedicacao();
		this.dataDeFimDaMedicacao=med.getDataDeFimDaMedicacao();
		this.dataDeInicioDaMedicacao=med.getDataDeInicioDaMedicacao();
		this.dose=med.getDose();
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

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}
	
	
}
