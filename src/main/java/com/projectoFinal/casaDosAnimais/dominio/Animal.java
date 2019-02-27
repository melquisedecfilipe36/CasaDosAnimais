package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String nome;
	String sexo;
	String cor;
	
	@Temporal(TemporalType.DATE)
	Date dataNascimento;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="especie_id")
	Especie especie;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	Cliente cliente;
	
	
	@JsonIgnore
	@OneToMany( mappedBy="animal")
	private List<Marcacao> marcacoes =new ArrayList<>();
	
	@JsonIgnore
	@OneToMany( mappedBy="animal")
	private List<Consulta> consultas =new ArrayList<>();
	
	
	Animal(){
		
		
	}


	public Animal(Integer id, String nome, String sexo, String cor, Date dataNascimento, Especie especie,
			Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cor = cor;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.cliente = cliente;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Especie getEspecie() {
		return especie;
	}


	public void setEspecie(Especie especie) {
		this.especie = especie;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<Marcacao> getMarcacoes() {
		return marcacoes;
	}


	public void setMarcacoes(List<Marcacao> marcacoes) {
		this.marcacoes = marcacoes;
	}


	public List<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
