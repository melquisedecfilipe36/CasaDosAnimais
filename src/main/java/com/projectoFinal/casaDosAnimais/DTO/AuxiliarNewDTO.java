package com.projectoFinal.casaDosAnimais.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class AuxiliarNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String funcao;
	
    private Date dataNascimentoAuxiliar;
	
    private Date dataMarcacao;
	private String observacaoMarcacao;
	private Integer veterinarioIdMarcacao;
	private Integer animalIdMarcacao;
	private Integer tipoMarcacao;
	
	
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
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Date getDataNascimentoAuxiliar() {
		return dataNascimentoAuxiliar;
	}
	public void setDataNascimentoAuxiliar(Date dataNascimentoAuxiliar) {
		this.dataNascimentoAuxiliar = dataNascimentoAuxiliar;
	}
	public Date getDataMarcacao() {
		return dataMarcacao;
	}
	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}
	public String getObservacaoMarcacao() {
		return observacaoMarcacao;
	}
	public void setObservacaoMarcacao(String observacaoMarcacao) {
		this.observacaoMarcacao = observacaoMarcacao;
	}
	
	public Integer getAnimalIdMarcacao() {
		return animalIdMarcacao;
	}
	public void setAnimalIdMarcacao(Integer animalIdMarcacao) {
		this.animalIdMarcacao = animalIdMarcacao;
	}
	public Integer getTipoMarcacao() {
		return tipoMarcacao;
	}
	public void setTipoMarcacao(Integer tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}
	public Integer getVeterinarioIdMarcacao() {
		return veterinarioIdMarcacao;
	}
	public void setVeterinarioIdMarcacao(Integer veterinarioIdMarcacao) {
		this.veterinarioIdMarcacao = veterinarioIdMarcacao;
	}
	
	
	

}
