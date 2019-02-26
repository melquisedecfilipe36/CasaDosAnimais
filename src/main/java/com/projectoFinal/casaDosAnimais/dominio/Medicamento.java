package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medicamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String nome;
	Double valor;
	Integer quantidade;
	
	@OneToMany(mappedBy="id.medicamento")
	private Set<Medicacao> medicacoes = new HashSet<>();
	
	public Medicamento(){
		
		
		
	}

	
	public Medicamento(Integer id, String nome, Double valor, Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Set<Medicacao> getMedicacoes() {
		return medicacoes;
	}

	public void setMedicacoes(Set<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}
	
	
	

	

}
