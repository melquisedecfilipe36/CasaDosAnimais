package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	private Date dataNascimento;
	
	private String numeroDaCasa;
	private String rua;
	private String bairro;

	private Integer municipioId;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;
	
	private String telefone2;
	private String telefone3;
	
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nomeAnimal;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=10, message="O tamanho deve ser entre 5 e 10 caracteres")
	private String sexoAnimal;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho deve ser entre 5 e 20 caracteres")
	private String corAnimal;
	
	
	Date dataNascimentoAnimal;
	
	
	String descricaoRaca;
	
	String descricaoEspecie;
	
	
	
	public String getDescricaoRaca() {
		return descricaoRaca;
	}

	public void setDescricaoRaca(String descricaoRaca) {
		this.descricaoRaca = descricaoRaca;
	}

	public String getDescricaoEspecie() {
		return descricaoEspecie;
	}

	public void setDescricaoEspecie(String descricaoEspecie) {
		this.descricaoEspecie = descricaoEspecie;
	}

	public Date getDataNascimentoAnimal() {
		return dataNascimentoAnimal;
	}

	public void setDataNascimentoAnimal(Date dataNascimentoAnimal) {
		this.dataNascimentoAnimal = dataNascimentoAnimal;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getSexoAnimal() {
		return sexoAnimal;
	}

	public void setSexoAnimal(String sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}

	public String getCorAnimal() {
		return corAnimal;
	}

	public void setCorAnimal(String corAnimal) {
		this.corAnimal = corAnimal;
	}

	

	

	public ClienteNewDTO() {
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

	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	

}
