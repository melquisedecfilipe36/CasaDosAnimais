package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Marcacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDaMarcacao;
	
	String observacao;
	
	
	@ManyToOne
	@JoinColumn(name="auxiliar_id")
	private Auxiliar auxiliar;
	
	

	@ManyToOne
	@JoinColumn(name="tipomarcacao_id")
	private TipoMarcacao tipoMarcacao;
	
	
	
	@ManyToOne
	@JoinColumn(name="veterinario_id")
	private Veterinario veterinario;
	
	
	@ManyToOne
	@JoinColumn(name="animal_id")
	private Animal animal;
	
	public Marcacao(){
		
		
	}

	public Marcacao(Integer id, Date dataDaMarcacao, String observacao, Auxiliar auxiliar, TipoMarcacao tipoMarcacao,
			Veterinario veterinario, Animal animal) {
		super();
		this.id = id;
		this.dataDaMarcacao = dataDaMarcacao;
		this.observacao = observacao;
		this.auxiliar = auxiliar;
		this.tipoMarcacao = tipoMarcacao;
		this.veterinario = veterinario;
		this.animal = animal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDaMarcacao() {
		return dataDaMarcacao;
	}

	public void setDataDaMarcacao(Date dataDaMarcacao) {
		this.dataDaMarcacao = dataDaMarcacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Auxiliar getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Auxiliar auxiliar) {
		this.auxiliar = auxiliar;
	}

	public TipoMarcacao getTipoMarcacao() {
		return tipoMarcacao;
	}

	public void setTipoMarcacao(TipoMarcacao tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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
		Marcacao other = (Marcacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
