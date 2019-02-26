package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Cirurgia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String descricao;
	Double preco;
	
	
	@ManyToOne
	@JoinColumn(name="veterinario_id")
	private Veterinario veterinario;
	
	@OneToMany(mappedBy="id.cirurgia")
	private Set<Internamento> internamentos = new HashSet<>();
	
	
	public Cirurgia(){
		
		
		
	}

	
	
	public Cirurgia(Integer id, String descricao, Double preco, Veterinario veterinario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.veterinario = veterinario;
	
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Veterinario getVeterinario() {
		return veterinario;
	}


	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}


	public Set<Internamento> getInternamentos() {
		return internamentos;
	}


	public void setInternamentos(Set<Internamento> internamentos) {
		this.internamentos = internamentos;
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
		Cirurgia other = (Cirurgia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
