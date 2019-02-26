package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;

public class AuxiliarDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	String funcao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	String email;
	
	AuxiliarDTO(){
		
		
	}
	
	AuxiliarDTO(Auxiliar aux){
		
		this.id=aux.getId();
		this.nome=aux.getNome();
		this.email=aux.getEmail();
		this.funcao=aux.getFuncao();
		
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
