package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Tratamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String descricao;
	String observacao;
	
	
	@ManyToOne
	@JoinColumn(name="consulta_id")
	private Consulta consulta;
	
	@OneToMany(mappedBy="id.tratamento")
	private Set<Vacinacao> vacinas = new HashSet<>();
	
	@OneToMany(mappedBy="id.tratamento")
	private Set<Internamento> internamentos = new HashSet<>();
	
	@OneToMany(mappedBy="id.tratamento")
	private Set<Medicacao> medicacoes = new HashSet<>();
	
	@OneToMany(mappedBy="id.tratamento")
	private Set<ExameLaboratorial> exames = new HashSet<>();
	
	
	public Tratamento(){
		
		
	}

	
	public Tratamento(Integer id, String descricao, String observacao, Consulta consulta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.observacao = observacao;
		this.consulta = consulta;
		
	}

	
	
	public double getValorTotalVacinacaoes() {
		
		double soma=0.0;
		for(Vacinacao ip: vacinas) {	
			soma =soma + ip.getSubTotal();
		}
		
		return soma;
	}

	public double getValorTotalMedicacoes() {
		
		double soma=0.0;
		for(Medicacao ip: medicacoes) {	
			soma =soma + ip.getSubTotal();
		}
		
		return soma;
	}
	
	
	public double getValorTotalInternamentos() {
		
		double soma=0.0;
		for(Internamento ip: internamentos) {	
			soma =soma + ip.getSubTotal();
		}
		
		return soma;
	}
	
	
	public double getValorTotalExames() {
		
		double soma=0.0;
		for(ExameLaboratorial ip: exames) {	
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Consulta getConsulta() {
		return consulta;
	}


	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setVacinas(Set<Vacinacao> vacinas) {
		this.vacinas = vacinas;
	}


	public List<Vacina> getVacinas(){
		
		List<Vacina> lista= new ArrayList<>();
		for(Vacinacao x: vacinas) {
			
			lista.add(x.getVacina());
		}
		
		return lista;
	}


	public List<Cirurgia> getCirurgias(){
		
		List<Cirurgia> lista= new ArrayList<>();
		for(Internamento x: internamentos) {
			
			lista.add(x.getCirurgia());
		}
		
		return lista;
	}
	
	
	public List<Medicamento> getMedicamentos(){
		
		List<Medicamento> lista= new ArrayList<>();
		for(Medicacao x: medicacoes) {
			
			lista.add(x.getMedicamento());
		}
		
		return lista;
	}
	
	public List<Exame> getExames(){
		
		List<Exame> lista= new ArrayList<>();
		for(ExameLaboratorial x: exames) {
			
			lista.add(x.getExame());
		}
		
		return lista;
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
		Tratamento other = (Tratamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
