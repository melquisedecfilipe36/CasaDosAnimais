package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Consulta implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dataDaConsulta;
	
	
	Double pesoDoAnimal;
	String observacao;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="consulta")
	Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name="veterinario_id")
	private Veterinario veterinario;
		
	
	@ManyToOne
	@JoinColumn(name="animal_id")
	private Animal animal;
	
	
	@JsonIgnore
	@OneToMany( mappedBy="consulta")
	private List<Tratamento> tratamentos =new ArrayList<>();
	
	@OneToMany(mappedBy="id.consulta")
	private Set<Stock> items = new HashSet<>();
	
	public Consulta(){
		
		
		
	}

	public Consulta(Integer id, Date dataDaConsulta, Double pesoDoAnimal, String observacao, Pagamento pagamento,
			Veterinario veterinario, Animal animal) {
		super();
		this.id = id;
		this.dataDaConsulta = dataDaConsulta;
		this.pesoDoAnimal = pesoDoAnimal;
		this.observacao = observacao;
		this.pagamento = pagamento;
		this.veterinario = veterinario;
		this.animal = animal;
		
	}

	public double getValorTotal() {
		
		double soma=0.0;
		for(Stock ip: items) {	
			soma =soma + ip.getSubTotal();
		}
		
		return soma;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDaConsulta() {
		return dataDaConsulta;
	}

	public void setDataDaConsulta(Date dataDaConsulta) {
		this.dataDaConsulta = dataDaConsulta;
	}

	public Double getPesoDoAnimal() {
		return pesoDoAnimal;
	}

	public void setPesoDoAnimal(Double pesoDoAnimal) {
		this.pesoDoAnimal = pesoDoAnimal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public Set<Stock> getItems() {
		return items;
	}

	public void setItems(Set<Stock> items) {
		this.items = items;
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
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
