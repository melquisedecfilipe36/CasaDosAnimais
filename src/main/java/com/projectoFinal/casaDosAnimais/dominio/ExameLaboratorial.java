package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class ExameLaboratorial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	ExameLaboratorialPK id = new ExameLaboratorialPK();
	
	String descricao;
	String resultado;
	Double valor;
	Integer unidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDoExame;
	
	ExameLaboratorial(){
		
		
	}

	public ExameLaboratorial(Exame exame,Tratamento tratamento, String descricao, String resultado, Double valor,
			Date dataDoExame) {
		super();
		id.setExame(exame);
		id.setTratamento(tratamento);
		this.descricao = descricao;
		this.resultado = resultado;
		this.valor = valor;
		this.dataDoExame = dataDoExame;
	}
	
	public double getSubTotal() {
		
		return valor* unidade;
		
	}
	
	
	
	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Exame getExame() {
		
		return id.getExame();
	}
	
	public Tratamento getTratamento() {
		
		return id.getTratamento();
	}

	public ExameLaboratorialPK getId() {
		return id;
	}

	public void setId(ExameLaboratorialPK id) {
		this.id = id;
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

	public Date getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(Date dataDoExame) {
		this.dataDoExame = dataDoExame;
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
		ExameLaboratorial other = (ExameLaboratorial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
