package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.InternamentoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Internamento;

@Service
public class InternamentoServicos {
		
	@Autowired
	private InternamentoDAO internamentoDados;
	
	
	public Internamento procurar(Integer id) {
		
		Optional<Internamento> obj = internamentoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Internamento.class.getName()));
	
	}
	
	public Internamento inserir(Internamento obj) {
		
		obj.setId(null);
		
		return internamentoDados.save(obj);
	}

}
