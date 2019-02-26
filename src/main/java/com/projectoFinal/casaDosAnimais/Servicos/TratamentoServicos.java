package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.TratamentoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Tratamento;

@Service
public class TratamentoServicos {
	
	 
	
	@Autowired
	private TratamentoDAO tratamentoDados;
	
	public Tratamento procurar(Integer id) {
		
		Optional<Tratamento> obj = tratamentoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tratamento.class.getName()));
	
	}
	
	public Tratamento inserir(Tratamento obj) {
		
		obj.setId(null);
		
		return tratamentoDados.save(obj);
	}

}
