package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

public class VeterinarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	String email;
	
	Integer numeroDaOrdemDosVeterinarios;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	String especialidade;

	VeterinarioDTO(){
		
		
	}
	
	VeterinarioDTO(Veterinario vet){
		
		this.id=vet.getId();
		this.email=vet.getEmail();
		this.numeroDaOrdemDosVeterinarios=vet.getNumeroDaOrdemDosVeterinarios();
		this.especialidade=vet.getEspecialidade();
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
	
	
	
	
}
