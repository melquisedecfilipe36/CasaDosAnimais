package com.projectoFinal.casaDosAnimais.dominio;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectoFinal.casaDosAnimais.dominio.enumerado.EstadoPagamento;



@Entity
public class Pagamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	String tipo;
	Double valorTotal;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date instante;
	
	Integer estadoPagamento;
	
	
	
	@OneToOne
	@JoinColumn(name="consulta_id")
	@MapsId
	Consulta consulta;

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	Cliente cliente;
	
	Pagamento(){
		
	}

	public Pagamento(Integer id, String tipo, Double valorTotal, EstadoPagamento estadoPagamento, Consulta consulta,
		Cliente cliente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valorTotal = valorTotal;
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
		this.consulta = consulta;
		this.cliente = cliente;
	}
	
	
	

	public Pagamento(Integer id, String tipo, Double valorTotal, Date instante, EstadoPagamento estadoPagamento,
			Consulta consulta, Cliente cliente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valorTotal = valorTotal;
		this.instante = instante;
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
		this.consulta = consulta;
		this.cliente = cliente;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public EstadoPagamento getEstadoPagamento() {
		return  EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
