package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veterinario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String nome;
	
	@Column(unique=true)
	String email;
	
	Integer numeroDaOrdemDosVeterinarios;
	String especialidade;
	
	@Temporal(TemporalType.DATE)
	Date dataNascimento;
	
	@JsonIgnore
	@OneToMany( mappedBy="veterinario")
	private List<Marcacao> marcacoes =new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany( mappedBy="veterinario")
	private List<Consulta> consultas =new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany( mappedBy="veterinario")
	private List<Cirurgia> cirurgias =new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany( mappedBy="veterinario")
	private List<Vacina> vacinas =new ArrayList<>();
	
	Veterinario(){
		
		
	}

	public Veterinario(Integer id, String nome, String email, Integer numeroDaOrdemDosVeterinarios,
			String especialidade, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.numeroDaOrdemDosVeterinarios = numeroDaOrdemDosVeterinarios;
		this.especialidade = especialidade;
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroDaOrdemDosVeterinarios() {
		return numeroDaOrdemDosVeterinarios;
	}

	public void setNumeroDaOrdemDosVeterinarios(Integer numeroDaOrdemDosVeterinarios) {
		this.numeroDaOrdemDosVeterinarios = numeroDaOrdemDosVeterinarios;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<Cirurgia> getCirurgias() {
		return cirurgias;
	}

	public void setCirurgias(List<Cirurgia> cirurgias) {
		this.cirurgias = cirurgias;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
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
		Veterinario other = (Veterinario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
