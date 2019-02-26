package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projectoFinal.casaDosAnimais.dominio.Animal;

public class AnimalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=10, message="O tamanho deve ser entre 5 e 10 caracteres")
	String sexo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho deve ser entre 5 e 20 caracteres")
	String cor;
	
	AnimalDTO(){
		
		
	}
	
	AnimalDTO(Animal animal){
		
		this.id=animal.getId();
		this.cor=animal.getCor();
		this.nome=animal.getNome();
		this.sexo=animal.getSexo();
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
	
	
}
